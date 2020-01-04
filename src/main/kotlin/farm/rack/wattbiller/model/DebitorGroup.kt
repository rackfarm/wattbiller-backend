package farm.rack.wattbiller.model

import farm.rack.wattbiller.model.meter.Meter
import io.micronaut.data.annotation.Id
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
data class DebitorGroup(val name: String = "",
                        @OneToMany(mappedBy = "debitorGroup") val members: List<DebitorGroupMembership> = arrayListOf(),
                        @OneToMany(mappedBy = "debitorGroup") val meters: List<Meter> = arrayListOf()
) : AbstractEntity() {

    fun getMemberMap(): Map<User, Double> {
        val map = hashMapOf<User,Double>()
        members.forEach{map.put(it.user, it.percentage)}
        return map

    }
}