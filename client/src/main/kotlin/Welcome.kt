import csstype.px
import emotion.react.css
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.hildan.krossbow.stomp.StompClient
import org.hildan.krossbow.stomp.StompSession
import org.hildan.krossbow.stomp.frame.FrameBody
import org.hildan.krossbow.stomp.frame.StompFrame
import org.hildan.krossbow.stomp.headers.StompSendHeaders
import org.hildan.krossbow.stomp.subscribe
import org.hildan.krossbow.websocket.sockjs.SockJSClient
import react.*
import react.dom.html.InputType
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.input

external interface WelcomeProps : Props {
    var name: String
}

val mainScope = MainScope()

val Welcome = FC<WelcomeProps> { props ->
    var name by useState(props.name)
    var session by useState<StompSession>()
    var subscription by useState<Flow<StompFrame.Message>>()

    useEffectOnce {
        mainScope.launch {
            val stompClient = StompClient(SockJSClient())
            session = stompClient.connect("http://localhost:8080/ws")
        }
    }

    useEffect(session) {
        mainScope.launch {
            subscription = session?.subscribe("/topic/chat.name")
        }
    }

    useEffect(subscription) {
        println("SUBSCRIPTION CHANGED")
        println(JSON.stringify(subscription))
        mainScope.launch {
            subscription?.cancellable()?.collect {
                println(it.bodyAsText)
            }
        }
    }




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
    button {
        onClick = {
            mainScope.launch {
                session?.send(StompSendHeaders(destination = "/topic/push"), FrameBody.Text(name))
            }
        }
        +"Send"
    }
}