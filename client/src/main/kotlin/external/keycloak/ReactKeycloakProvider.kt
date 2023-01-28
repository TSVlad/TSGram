@file:JsModule("@react-keycloak/web")
@file:JsNonModule

package external.keycloak

import react.ComponentClass
import react.Props

@JsName("ReactKeycloakProvider")
external val ReactKeycloakProvider : ComponentClass<ReactKeycloakProviderProps>

external interface ReactKeycloakProviderProps : Props {
    var authClient: Keycloak
    var initOptions: KeycloakInitOptions
}

@JsName("useKeycloak")
external fun useKeycloak() : KeycloakState

@JsName("AuthClient")
external class AuthClient {
    var token: String?
}