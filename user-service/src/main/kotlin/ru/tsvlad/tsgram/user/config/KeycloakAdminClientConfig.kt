package ru.tsvlad.tsgram.user.config

import org.keycloak.OAuth2Constants.CLIENT_CREDENTIALS
import org.keycloak.adapters.KeycloakConfigResolver
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver
import org.keycloak.admin.client.Keycloak
import org.keycloak.admin.client.KeycloakBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.tsvlad.tsgram.user.common.SECRET


@Configuration
class KeycloakAdminClientConfig {

    @Bean
    fun keycloak() : Keycloak {
        val keycloakDeployment = keycloakConfigResolver().resolve(null)
        return KeycloakBuilder.builder()
            .grantType(CLIENT_CREDENTIALS)
            .serverUrl(keycloakDeployment.authServerBaseUrl)
            .realm(keycloakDeployment.realm)
            .clientId(keycloakDeployment.resourceName)
            .clientSecret(keycloakDeployment.resourceCredentials[SECRET] as String)
            .build()
    }
    @Bean
    fun keycloakConfigResolver() : KeycloakConfigResolver {
        return KeycloakSpringBootConfigResolver()
    }
}