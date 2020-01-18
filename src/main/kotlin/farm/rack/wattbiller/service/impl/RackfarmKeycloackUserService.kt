package farm.rack.wattbiller.service.impl

import farm.rack.wattbiller.jpa.UserRepository
import farm.rack.wattbiller.model.User
import farm.rack.wattbiller.service.UserService
import io.micronaut.security.utils.SecurityService
import io.micronaut.spring.tx.annotation.Transactional
import java.util.Optional
import javax.inject.Singleton

@Singleton
@Transactional
class RackfarmKeycloackUserService(
        val securityService: SecurityService,
        val userRepository: UserRepository
) : UserService {

    private val USERID_ATTRIBUTE = "sub"
    private val USERNAME_ATTRIBUTE = "preferred_username"
    private val EMAIL_ATTRIBUTE = "email"

    override fun getUser(): Optional<User> {
        if (!securityService.isAuthenticated) {
            return Optional.empty()
        }

        val auth = securityService.authentication.get()
        val userId = auth.attributes[USERID_ATTRIBUTE] as String
        val username = auth.attributes[USERNAME_ATTRIBUTE] as String
        val email = auth.attributes[EMAIL_ATTRIBUTE] as String

        val existingUser = userRepository.findById(userId)
        if (existingUser.isPresent) {
            return existingUser
        }

        val user = User(userId, username, email)
        return Optional.of(userRepository.save(user))
    }
}
