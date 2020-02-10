package farm.rack.wattbiller.service.crud

import farm.rack.wattbiller.model.User
import java.util.Optional

interface UserService {

    fun getLoggedInUserOrThrow(): User

    fun getUser(): Optional<User>

    fun findByUsername(username: String): Optional<User>

    fun readAllUsers(): List<User>
}
