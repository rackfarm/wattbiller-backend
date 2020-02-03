package farm.rack.wattbiller.config

import io.micronaut.context.annotation.ConfigurationProperties
import org.keycloak.OAuth2Constants
import org.keycloak.admin.client.Keycloak
import org.keycloak.admin.client.KeycloakBuilder

@ConfigurationProperties("keycloak.admin")
class KeycloakConfiguration {
    lateinit var realm: String
    lateinit var serverUrl: String
    lateinit var clientId: String
    lateinit var username: String
    lateinit var password: String

    fun buildKeycloakAdminClient(): Keycloak? {
        println(this)
        return KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(realm)
                .clientId(clientId)
                .username(username)
                .password(password)
                .grantType(OAuth2Constants.PASSWORD)
                .build()
    }

    override fun toString(): String {
        return "KeycloakConfiguration(realm='$realm', serverUrl='$serverUrl', clientId='$clientId', username='$username', password='$password')"
    }

}
