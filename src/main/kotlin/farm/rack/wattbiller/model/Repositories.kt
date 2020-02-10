package farm.rack.wattbiller.model

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.Optional

@Repository
interface UserRepository : CrudRepository<User, String> {
    fun findByUsername(username: String): User
}

@Repository
interface MeterRepository : CrudRepository<Meter, Long> {
    fun findByDebitorGroupId(debitorGroupId: Long): List<Meter>
}

@Repository
interface MeterReadingRepository : CrudRepository<MeterReading, Long> {
    fun findByMeterId(meterId: Long): List<MeterReading>
    fun findByBilledWithinPeriodIsNullAndMeasuredAtBetween(date1: ZonedDateTime, date2: ZonedDateTime): List<MeterReading>
}

@Repository
interface BillingPeriodRepository : CrudRepository<BillingPeriod, Long> {
    fun findByBilledFalseAndEndDateBefore(endDate: LocalDate): List<BillingPeriod>
    fun findTopOrderByEndDateDesc(): Optional<BillingPeriod>
}

@Repository
interface DebitorGroupRepository : CrudRepository<DebitorGroup, Long>

@Repository
interface DebitorGroupMembershipRepository : CrudRepository<DebitorGroupMembership, Long>

@Repository
interface UserBillRepository : CrudRepository<UserBill, Long> {
    fun findByDebitor(debitor: String): List<UserBill>
}

@Repository
interface UserBillEntryRepository : CrudRepository<UserBillEntry, Long>

@Repository
interface MeterCostRepository : CrudRepository<MeterCost, Long>

