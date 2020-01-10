package farm.rack.wattbiller.model

import javax.persistence.*

/**
 * All costs related to a certain meter
 */
@Entity
data class PeriodicStatement(var name: String = "",
                             @ManyToOne var meter: Meter = Meter(),
                             @OneToOne var billingPeriod: BillingPeriod = BillingPeriod(),
                             var amount: Double = 0.0,
                             @ManyToOne var debitorGroup: DebitorGroup = DebitorGroup(),
                             @OneToMany var meterReadings: List<MeterReading> = arrayListOf()) : AbstractEntity() {

}
