package farm.rack.wattbiller.config

import io.micronaut.context.annotation.ConfigurationProperties


@ConfigurationProperties("keycloak.admin")
class KeycloakConfiguration {
    lateinit var realm: String
    lateinit var serverUrl: String
    lateinit var clientId: String
    lateinit var username: String
    lateinit var password: String

    override fun toString(): String {
        return "KeycloakConfiguration(realm='$realm', serverUrl='$serverUrl', clientId='$clientId', username='$username')"
    }

}
