package farm.rack.wattbiller.model

import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
data class DebitorGroupMembership(@ManyToOne var user: User = User(),
                                  @ManyToOne var debitorGroup: DebitorGroup = DebitorGroup(),
                                  var percentage: Double = 0.0) : AbstractEntity()
