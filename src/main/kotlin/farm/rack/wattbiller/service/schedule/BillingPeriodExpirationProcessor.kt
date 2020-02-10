package farm.rack.wattbiller.service.schedule

interface BillingPeriodExpirationProcessor {
    fun billExpiredPeriods()
    fun createNewBillingPeriodIfNeeded()
}
