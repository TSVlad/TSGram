import external.keycloak.Keycloak
import external.keycloak.KeycloakConfig
import external.keycloak.KeycloakInitOptions
import external.keycloak.ReactKeycloakProvider
import kotlinx.coroutines.MainScope
import react.FC
import react.Props

external interface WelcomeProps : Props {
    var name: String
}

val mainScope = MainScope()




val Welcome = FC<WelcomeProps> { props ->
    val keycloak = Keycloak(KeycloakConfig(
        url = "http://localhost:8484/auth",
        realm = "tsgram",
        clientId = "tsgram-ui"
    ))


    ReactKeycloakProvider {
        authClient = keycloak
        initOptions = KeycloakInitOptions(
            onLoad = "login-required"
        )

        HomePage {

        }
    }
}