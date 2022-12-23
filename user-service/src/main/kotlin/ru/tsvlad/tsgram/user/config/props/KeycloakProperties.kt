package ru.tsvlad.tsgram.user.config.props

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "keycloak")
data class KeycloakProperties(
    var realm: String = ""
)