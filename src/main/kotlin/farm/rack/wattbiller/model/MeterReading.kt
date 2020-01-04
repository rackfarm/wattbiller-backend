package farm.rack.wattbiller.model

import farm.rack.wattbiller.model.AbstractEntity
import farm.rack.wattbiller.model.Meter
import java.time.ZonedDateTime
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
data class MeterReading(@ManyToOne val meter: Meter = Meter(),
                        val timeWhenMeasured: ZonedDateTime = ZonedDateTime.now(),
                        val value: Double = 0.0
): AbstractEntity()