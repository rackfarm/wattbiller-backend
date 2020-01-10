package farm.rack.wattbiller.model

import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
data class Meter(val name: String = "",
                 @ManyToOne val debitorGroup: DebitorGroup = DebitorGroup(),
                 @OneToMany(mappedBy = "meter") val meterReadings: List<MeterReading> = arrayListOf(),
                 @ManyToOne val creditor: User = User()
): AbstractEntity() {
}
