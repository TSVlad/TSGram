import csstype.px
import emotion.react.css
import external.bootstrap.Button
import external.keycloak.KeycloakState
import external.keycloak.useKeycloak
import kotlinx.coroutines.launch
import react.FC
import react.Props
import react.dom.html.InputType
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.input

external interface HomePageProps : Props {

}

val HomePage = FC<HomePageProps> { props ->


    //    var session by useState<StompSession>()
//    var subscription by useState<Flow<StompFrame.Message>>()
//
//    useEffectOnce {
//        mainScope.launch {
//            val stompClient = StompClient(SockJSClient())
//            session = stompClient.connect("http://localhost:8080/ws")
//        }
//    }
//
//    useEffect(session) {
//        mainScope.launch {
//            subscription = session?.subscribe("/topic/chat.name")
//        }
//    }
//
//    useEffect(subscription) {
//        println("SUBSCRIPTION CHANGED")
//        println(JSON.stringify(subscription))
//        mainScope.launch {
//            subscription?.cancellable()?.collect {
//                println(it.bodyAsText)
//            }
//        }
//    }

    val keycloakState = useKeycloak()


    input {
        css {
            marginTop = 5.px
            marginBottom = 5.px
            fontSize = 14.px
        }
        type = InputType.text
        value = name
        onChange = { event ->
            name = event.target.value
        }
    }
    Button {
        variant = "primary"

        +"BUTTON"
    }
    button {
        onClick = {
            mainScope.launch {
//                session?.send(StompSendHeaders(destination = "/topic/push"), FrameBody.Text(name))
                println(JSON.stringify(keycloakState))
                println(keycloakState.keycloak.idToken)
            }
        }
        +"Send"
    }
}