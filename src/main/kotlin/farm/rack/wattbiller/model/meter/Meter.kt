package farm.rack.wattbiller.model.meter

import farm.rack.wattbiller.model.AbstractEntity
import farm.rack.wattbiller.model.DebitorGroup
import farm.rack.wattbiller.model.User
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
data class Meter(val name: String = "",
                 @ManyToOne val debitorGroup: DebitorGroup = DebitorGroup(),
                 @OneToMany(mappedBy = "meter") val readings: List<MeterReading> = arrayListOf(),
                 @ManyToOne val creditor: User = User()
): AbstractEntity() {
}