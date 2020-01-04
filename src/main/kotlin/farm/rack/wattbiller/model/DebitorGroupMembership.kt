package farm.rack.wattbiller.model

import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
data class DebitorGroupMembership(@ManyToOne val user: User = User(),
                                  @ManyToOne val debitorGroup: DebitorGroup = DebitorGroup(),
                                  val percentage: Double = 0.0): AbstractEntity(){
}