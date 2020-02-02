package farm.rack.wattbiller.model

import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
data class DebitorGroup(var name: String = "",
                        @OneToMany(mappedBy = "debitorGroup") var members: List<DebitorGroupMembership> = arrayListOf(),
                        @OneToMany(mappedBy = "debitorGroup") var meters: List<Meter> = arrayListOf()
) : AbstractEntity() {

    fun getMemberMap(): Map<User, Double> {
        val map = hashMapOf<User, Double>()
        members.forEach { map.put(it.user, it.percentage) }
        return map

    }
}
