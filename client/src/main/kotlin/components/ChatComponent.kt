package components

import common.Chat
import common.Message
import csstype.*
import emotion.react.css
import react.FC
import react.Props
import react.State
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.span
import react.key

external interface ChatProperties : Props {
    var messages: List<Message>
}

interface ChatState : State {
    var messages: List<Message>
    var messageText: String
}

val ChatComponent = FC<ChatProperties> { props ->
    div {
        css {
            display = Display.flex
            flexDirection = FlexDirection.column
            height = 100.pct
            backgroundColor = Color("#1f2126")
            color = Color("#fff")
        }

        // Messages list
        div {
            css {
                overflowY = Overflow.scroll
                padding = Padding(16.px, 0.px)
                marginBottom = 10.px
            }
            props.messages.forEach { message ->
                div {
                    css {
                        display = Display.flex
                        flexDirection = if (message.isMine) FlexDirection.rowReverse else FlexDirection.row
                        alignItems = AlignItems.center
                        marginBottom = 8.px
                    }
                    key = message.id

                    // Message bubble
                    div {
                        css {
                            backgroundColor =
                                if (message.isMine) Color("#dcf8c6") else  Color("#292b2f")
                            color =
                                if (message.isMine) Color("#000") else  Color("#fff")
                            padding = Padding(12.px, 16.px)
                            position = Position.relative
                            boxShadow = BoxShadow(1.px, 0.px, Color("#0004"))
                            maxWidth = 70.pct
                        }
                        +message.content
                        span {
                            css {
                                position = Position.absolute
                                fontSize = 0.7.em
                                top = (-18).px
                                if (message.isMine) right = 0.px else left = 0.px
                            }
                            +message.timestamp
                        }
                    }
                }
            }
        }
    }
}