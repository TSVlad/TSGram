package components

import common.Chat
import common.Message
import csstype.ClassName
import org.w3c.dom.HTMLInputElement
import react.FC
import react.Props
import react.dom.html.ReactHTML.b
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h2
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.span
import react.useState

external interface ChatProps : Props {
    var chat: Chat
    var username: String
    var messages: List<Message>
    var onSendMessage: (String) -> Unit
}

val ChatItemComponent = FC<ChatProps> { props ->
//    div {
//        div {
//            + props.name
//        }
//        div {
//            + props.lastMessage
//        }
//    }
//    hr {
//
//    }
}