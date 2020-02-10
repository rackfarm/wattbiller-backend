package farm.rack.wattbiller.service.schedule

import io.micronaut.scheduling.annotation.Scheduled
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BillingPeriodCheckScheduler @Inject constructor(val expirationProcessor: BillingPeriodExpirationProcessor) {
    @Scheduled(fixedDelay = "1d", initialDelay = "5s")
    fun checkForBillingPeriodExpiration() {
        expirationProcessor.createNewBillingPeriodIfNeeded()
        expirationProcessor.billExpiredPeriods()
    }
}
