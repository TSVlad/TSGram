import common.Chat
import common.Message
import components.ChatComponent
import components.ChatListComponent
import csstype.Color
import csstype.Display
import csstype.px
import csstype.vh
import emotion.react.css
import external.bootstrap.Col
import external.bootstrap.Container
import external.bootstrap.Row
import external.keycloak.useKeycloak
import kotlinx.coroutines.launch
import react.FC
import react.Props
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1

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

    Container {
        fluid = true

        Row {
//            Col {
//                sm = 1
//                md = 1
//                lg = 1
//                xl = 2
//                xxl = 2
//            }

            Col {
//                sm = 5
//                md = 4
//                lg = 3
//                xl = 2
//                xxl = 2

                sm = 4

                ChatListComponent {
                    chats = listOf(
                        Chat("1", "Chat 1", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fcdn.ebaumsworld.com%2FmediaFiles%2Fpicture%2F1151541%2F84693449.png&f=1&nofb=1&ipt=2b122efe86816f2eddf0726c0f0065d5f2e04cd129f6ceae28d366d4f8754f98&ipo=images", "Last message 1", 2),
                        Chat("2", "Chat 2", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fcdn.ebaumsworld.com%2FmediaFiles%2Fpicture%2F1151541%2F84693449.png&f=1&nofb=1&ipt=2b122efe86816f2eddf0726c0f0065d5f2e04cd129f6ceae28d366d4f8754f98&ipo=images", "Last message 2", 0),
                        Chat("3", "Chat 3", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fcdn.ebaumsworld.com%2FmediaFiles%2Fpicture%2F1151541%2F84693449.png&f=1&nofb=1&ipt=2b122efe86816f2eddf0726c0f0065d5f2e04cd129f6ceae28d366d4f8754f98&ipo=images", "Last message 3", 5),
                        Chat("4", "Chat 4", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fcdn.ebaumsworld.com%2FmediaFiles%2Fpicture%2F1151541%2F84693449.png&f=1&nofb=1&ipt=2b122efe86816f2eddf0726c0f0065d5f2e04cd129f6ceae28d366d4f8754f98&ipo=images", "Last message 4", 0),
                        Chat("5", "Chat 5", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fcdn.ebaumsworld.com%2FmediaFiles%2Fpicture%2F1151541%2F84693449.png&f=1&nofb=1&ipt=2b122efe86816f2eddf0726c0f0065d5f2e04cd129f6ceae28d366d4f8754f98&ipo=images", "Last message 5", 1)
                    )

                    selectedChatId = "2"

                    onSelectChat = {
                        println(it)
                        selectedChatId = it
                    }
                }
            }

            Col {
//                sm = 5
//                md = 6
//                lg = 7
//                xl = 6
//                xxl = 6

                ChatComponent {
                    messages = listOf(
                        Message(
                            id = "1",
                            content = "Привет, как дела?",
                            timestamp = "12:30 PM",
                            isMine = true
                        ),
                        Message(
                            id = "2",
                            content = "Привет! Всё хорошо, а у тебя?",
                            timestamp = "12:32 PM",
                            isMine = false
                        ),
                        Message(
                            id = "3",
                            content = "Отлично, спасибо!",
                            timestamp = "12:34 PM",
                            isMine = true
                        )
                    )
                }
            }

//            Col {
//                sm = 1
//                md = 1
//                lg = 1
//                xl = 2
//                xxl = 2
//            }
        }
    }
}