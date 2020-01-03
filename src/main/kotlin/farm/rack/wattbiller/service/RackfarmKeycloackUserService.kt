package farm.rack.wattbiller.service

import farm.rack.wattbiller.jpa.UserRepository
import farm.rack.wattbiller.model.User
import io.micronaut.security.utils.SecurityService
import io.micronaut.spring.tx.annotation.Transactional
import java.util.Optional
import javax.inject.Singleton

@Singleton
@Transactional
class RackfarmKeycloackUserService (
        var securityService: SecurityService,
        var userRepository: UserRepository
) : UserService {

    override fun getUser(): Optional<User> {
        if (!securityService.isAuthenticated) {
            return Optional.empty()
        }

        val auth = securityService.authentication.get()
        val userId = auth.attributes["sub"] as String

        val existingUser = userRepository.findById(userId)
        if (existingUser.isPresent) {
            return existingUser
        }

        val user = User(userId, auth.attributes["preferred_username"] as String)
        return Optional.of(userRepository.save(user))
    }
}