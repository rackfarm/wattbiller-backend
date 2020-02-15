package farm.rack.wattbiller.service.schedule

import farm.rack.wattbiller.model.*
import farm.rack.wattbiller.service.crud.UserService
import java.time.*
import java.time.format.TextStyle
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultBillingPeriodExpirationProcessor @Inject constructor(val billingPeriodRepository: BillingPeriodRepository,
                                                                  val meterReadingRepository: MeterReadingRepository,
                                                                  val meterCostRepository: MeterCostRepository,
                                                                  val userBillEntryRepository: UserBillEntryRepository,
                                                                  val userBillRepository: UserBillRepository,
                                                                  val meterRepository: MeterRepository,
                                                                  val userService: UserService)
    : BillingPeriodExpirationProcessor {
    override fun billExpiredPeriods() {
        val expiredPeriods = billingPeriodRepository.findByBilledFalseAndEndDateBefore(LocalDate.now().minusDays(5))
        expiredPeriods.forEach { billPeriod(it) }
    }

    override fun createNewBillingPeriodIfNeeded() {
        val newestBillingPeriod = billingPeriodRepository.findTopOrderByEndDateDesc()
        var lastEnd = LocalDate.now().minusDays(1)
        if (newestBillingPeriod.isPresent) {
            lastEnd = newestBillingPeriod.get().endDate
            if (lastEnd > LocalDate.now().plusDays(2)) {
                return
            }
        }
        val startDate = lastEnd.plusDays(1)
        val endDate = startDate.plusMonths(1)
        val startName = startDate.month.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)
        val endName = endDate.month.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)
        var periodName = "$startName-$endName"
        if (startName == endName) {
            periodName = startName
        }
        billingPeriodRepository.save(BillingPeriod(periodName, startDate, startDate.plusMonths(1)))
    }

    fun billPeriod(periodToBill: BillingPeriod): List<UserBill> {
        val startTime = ZonedDateTime.of(periodToBill.startDate, LocalTime.MIDNIGHT, ZoneId.systemDefault())
        val endTime = ZonedDateTime.of(periodToBill.endDate.plusDays(1), LocalTime.MIDNIGHT, ZoneId.systemDefault())
        val readingsInPeriod = meterReadingRepository.findByBilledWithinPeriodIsNullAndMeasuredAtBetween(startTime, endTime)
        val meterCosts = calculateMeterCostsForReadings(readingsInPeriod)
        val userBills = userService.readAllUsers().map { user -> generateUserBillForUser(user, meterCosts, periodToBill) }
        readingsInPeriod.forEach {
            it.billedWithinPeriod = periodToBill
            meterReadingRepository.save(it)
        }
        return userBills
    }

    private fun calculateMeterCostsForReadings(readingsInPeriod: List<MeterReading>): Map<Meter, Double> {
        return readingsInPeriod
                .groupBy { it.meter }
                .mapValues {
                    when (it.key.readingType) {
                        ReadingType.CUMULATIVE   -> it.value.sumByDouble { meterReading -> meterReading.value * it.key.costFactor }
                        ReadingType.ABSOLUTE_MAX -> {
                            it.value.maxBy { reading -> reading.value }?.value ?: 0.0 * it.key.costFactor
                        }
                        ReadingType.ABSOLUTE_NEW -> {
                            it.value.maxBy { reading -> reading.measuredAt }?.value ?: 0.0 * it.key.costFactor
                        }
                        ReadingType.RELATIVE_MAX -> {
                            val maxValue = it.value.maxBy { reading -> reading.value }?.value ?: 0.0
                            var relativeValue = maxValue - it.key.lastBilledValue
                            if (relativeValue.compareTo(0) <= 0) relativeValue = 0.0
                            it.key.lastBilledValue = maxValue
                            meterRepository.save(it.key)
                            relativeValue * it.key.costFactor
                        }
                    }
                }
    }

    private fun generateUserBillForUser(user: User, costMap: Map<Meter, Double>, billingPeriod: BillingPeriod): UserBill {
        val userBill = userBillRepository.save(UserBill(0L, billingPeriod, user.username, arrayListOf()))
        val entryList = arrayListOf<UserBillEntry>()
        val metersByCreditor = costMap.keys.filter { meter -> meter.debitorGroup.getMemberMap().containsKey(user) }.groupBy { it.creditor }
        metersByCreditor.forEach { creditorToMetersPair ->
            val meterCostList = arrayListOf<MeterCost>()
            creditorToMetersPair.value.forEach { meter ->
                val monthlyMeterCost = costMap.getOrDefault(meter, 0.0)
                val userPercentage = meter.debitorGroup.getMemberMap().getOrDefault(user, 0.0)
                val cost = monthlyMeterCost.div(100).times(userPercentage)
                val meterCost = meterCostRepository.save(MeterCost(0L, meter.name, cost))
                meterCostList.add(meterCost)
            }
            var userBillEntry = UserBillEntry(0L, creditorToMetersPair.key.username, creditorToMetersPair.key.userId, meterCostList.sumByDouble { it.cost }, userBill.id, PaymentStatus.OPEN, meterCostList)
            userBillEntry = userBillEntryRepository.save(userBillEntry)
            entryList.add(userBillEntry)
        }
        userBill.entries = entryList
        return userBillRepository.save(userBill)
    }
}
