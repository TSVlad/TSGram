package external.keycloak

data class KeycloakState(
    var initialized: Boolean,
    var keycloak: Keycloak
)

data class KeycloakConfig(
    var url: String,
    var realm: String,
    var clientId: String
)

