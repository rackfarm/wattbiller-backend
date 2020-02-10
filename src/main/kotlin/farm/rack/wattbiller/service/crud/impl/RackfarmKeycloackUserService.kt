package farm.rack.wattbiller.service.crud.impl

import farm.rack.wattbiller.config.KeycloakConfiguration
import farm.rack.wattbiller.model.User
import farm.rack.wattbiller.model.UserRepository
import farm.rack.wattbiller.service.crud.UserService
import io.micronaut.context.annotation.Requires
import io.micronaut.context.annotation.Value
import io.micronaut.runtime.event.annotation.EventListener
import io.micronaut.runtime.server.event.ServerStartupEvent
import io.micronaut.security.utils.SecurityService
import org.keycloak.admin.client.Keycloak
import java.util.Optional
import javax.inject.Singleton
import javax.transaction.Transactional

@Singleton
@Transactional
@Requires(classes = [SecurityService::class])
class RackfarmKeycloackUserService(
        val securityService: SecurityService,
        val userRepository: UserRepository,
        val keycloakConfiguration: KeycloakConfiguration,
        val keycloakAdminClient: Keycloak
) : UserService {

    private val USERID_ATTRIBUTE = "sub"
    private val USERNAME_ATTRIBUTE = "preferred_username"
    private val EMAIL_ATTRIBUTE = "email"

    @Value("\${keycloak.clientId}")
    lateinit var clientId: String

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

    override fun findByUsername(username: String): Optional<User> {
        return Optional.of(userRepository.findByUsername(username))
    }

    override fun getLoggedInUserOrThrow(): User {
        return getUser().orElseThrow { RuntimeException("User not logged in") }
    }

    @EventListener
    fun startUp(event: ServerStartupEvent) {
        println("Wattbiller Users:")
        readAllUsers().forEach { println(it.username) }
    }

    override fun readAllUsers(): List<User> {
        val realmResource = keycloakAdminClient.realm(keycloakConfiguration.realm)
        val clientUuid = realmResource.clients().findByClientId(clientId).first().id
        val keycloakUsers = realmResource.users().list()
        val wattBillerUsers = keycloakUsers
                .filter { realmResource.users().get(it.id).roles().clientLevel(clientUuid).listEffective().size > 0 }
                .map { User(it.id, it.username, it.email) }
                .toList()
        userRepository.saveAll(wattBillerUsers)
        return wattBillerUsers
    }
}
