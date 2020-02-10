package farm.rack.wattbiller.web

import farm.rack.wattbiller.model.User
import farm.rack.wattbiller.service.crud.UserService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import javax.inject.Inject

@Controller("/api/user")
@Secured(SecurityRule.IS_AUTHENTICATED)
class UserController {

    @Inject
    lateinit var userService: UserService

    @Get("/all")
    fun readAll(): List<User> {
        return userService.readAllUsers()
    }

    @Get("/{username}")
    fun readById(@PathVariable username: String): User {
        return userService.findByUsername(username).orElse(null)
    }
}
