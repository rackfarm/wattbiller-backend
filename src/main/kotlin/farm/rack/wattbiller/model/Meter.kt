package farm.rack.wattbiller.model

import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
data class Meter(var name: String = "",
                 @ManyToOne var debitorGroup: DebitorGroup = DebitorGroup(),
                 @OneToMany(mappedBy = "meter") var meterReadings: List<MeterReading> = arrayListOf(),
                 var costFactor: Double = 1.0,
                 var readingType: ReadingType = ReadingType.CUMULATIVE,
                 var lastBilledValue: Double = 0.0,
                 @ManyToOne var creditor: User = User()
) : AbstractEntity()
