package farm.rack.wattbiller.model

import javax.annotation.Nonnull
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class User(@Nonnull @Id var userId: String = "",
                @Nonnull var username: String = "",
                @Nonnull var email: String = "") {

}