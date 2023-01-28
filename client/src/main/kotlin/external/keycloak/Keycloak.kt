@file:JsModule("keycloak-js")
@file:JsNonModule

package external.keycloak

@JsName("default")
external class Keycloak(keycloakConfig: KeycloakConfig) {
    var idToken: String
}