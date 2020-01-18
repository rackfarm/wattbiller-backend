package farm.rack.wattbiller.model

import javax.annotation.Nonnull
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class User(@Nonnull @Id var userId: String = "",
                @Nonnull var username: String = "",
                @Nonnull var email: String = "",
                @OneToMany var creditedMeters: List<Meter> = arrayListOf()) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false

        if (userId != other.userId) return false

        return true
    }

    override fun hashCode(): Int {
        return userId.hashCode()
    }
}

