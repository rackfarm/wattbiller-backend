package farm.rack.wattbiller.service

import farm.rack.wattbiller.model.User
import java.util.Optional

interface UserService {

    fun getLoggedInUserOrThrow(): User

    fun getUser(): Optional<User>
}
