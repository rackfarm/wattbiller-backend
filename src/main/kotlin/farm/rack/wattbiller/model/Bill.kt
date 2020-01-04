package farm.rack.wattbiller.model

import javax.persistence.*

/**
 * All costs related to a certain meter
 */
@Entity
data class Bill(val name: String = "",
                @ManyToOne val meter: Meter = Meter(),
                @OneToOne val billingPeriod: BillingPeriod = BillingPeriod(),
                val amount: Double = 0.0,
                @ManyToOne val debitorGroup: DebitorGroup = DebitorGroup(),
                @OneToMany val meterReadings: List<MeterReading> = arrayListOf()) : AbstractEntity() {

}