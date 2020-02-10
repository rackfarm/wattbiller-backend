package farm.rack.wattbiller.config

import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Prototype
import org.keycloak.OAuth2Constants
import org.keycloak.admin.client.Keycloak
import org.keycloak.admin.client.KeycloakBuilder
import javax.inject.Singleton

@Singleton
@Factory
class KeycloakClientFactory(val keycloakConfiguration: KeycloakConfiguration) {

    @Prototype
    fun buildKeycloakAdminClient(): Keycloak {
        println(this)
        return KeycloakBuilder.builder()
                .serverUrl(keycloakConfiguration.serverUrl)
                .realm(keycloakConfiguration.realm)
                .clientId(keycloakConfiguration.clientId)
                .username(keycloakConfiguration.username)
                .password(keycloakConfiguration.password)
                .grantType(OAuth2Constants.PASSWORD)
                .build()!!
    }
}
