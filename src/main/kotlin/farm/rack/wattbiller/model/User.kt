package farm.rack.wattbiller.model

import javax.annotation.Nonnull
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class User(@Nonnull @Id var userId: String = "",
                @Nonnull var username: String = "",
                @Nonnull var email: String = "",
                @OneToMany var creditedMeters: List<Meter> = arrayListOf())
