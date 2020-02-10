package farm.rack.wattbiller.model

import java.time.ZonedDateTime
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
data class MeterReading(@ManyToOne var meter: Meter = Meter(),
                        var measuredAt: ZonedDateTime = ZonedDateTime.now(),
                        var value: Double = 0.0,
                        @ManyToOne(optional = true) var billedWithinPeriod: BillingPeriod? = null
) : AbstractEntity()
