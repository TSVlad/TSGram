package components

import common.Chat
import csstype.*
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.img
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.span
import react.dom.html.ReactHTML.ul
import kotlin.js.Date


external interface ChatListProperties : Props {
    var chats: List<Chat>
    var selectedChatId: String?
    var onSelectChat: (String) -> Unit
}

val ChatListComponent = FC<ChatListProperties> { props ->
    ul {
        css {
            backgroundColor = Color("#2D2F33")
            padding = 0.px
            margin = 0.px
//            listStyleType = ListStyleType.none
            display = Display.flex
            flexDirection = FlexDirection.column
            height = 100.pct
            overflowY = Overflow.scroll
        }
        props.chats.forEach { chat ->
            val isSelected = chat.id == props.selectedChatId
            li {
                css {
                    display = Display.flex
                    flexDirection = FlexDirection.row
                    alignItems = AlignItems.center
                    padding = 10.px
                    cursor = Cursor.pointer
                    backgroundColor = if (isSelected) Color("#3A3D41") else NamedColor.transparent
                    hover {
                        backgroundColor = if (isSelected) Color("#3A3D41") else Color("#404347")
                    }
                }
                onClick = { props.onSelectChat(chat.id) }
                img {
                    css {
                        height = 40.px
                        width = 40.px
                        borderRadius = 50.pct
                        marginRight = 10.px
                    }
                    src = chat.pictureRef
                }
                div {
                    css {
                        display = Display.flex
                        flexDirection = FlexDirection.column
//                        flexGrow = 1.0
                    }
                    div {
                        css {
                            display = Display.flex
                            flexDirection = FlexDirection.row
                            justifyContent = JustifyContent.spaceBetween
                            alignItems = AlignItems.center
                        }
                        span {
                            css {
                                fontWeight = FontWeight.bold
                                fontSize = 16.px
                                color = NamedColor.white
                            }
                            +chat.name
                        }
                        span {
                            css {
                                fontWeight = FontWeight.bold
                                fontSize = 12.px
                                color = Color("#B9BBBE")
                            }
                            +Date().toLocaleTimeString()
                        }
                    }
                    div {
                        css {
                            display = Display.flex
                            flexDirection = FlexDirection.row
                            alignItems = AlignItems.center
                        }
                        span {
                            css {
                                fontWeight = if (isSelected) FontWeight.bold else FontWeight.normal
                                fontSize = 14.px
                                color = if (isSelected) NamedColor.white else Color("#B9BBBE")
                            }
                            +"Last message from ${chat.name}: ${chat.lastMessage}"
                        }
                        if (chat.unreadCount > 0) {
                            div {
                                css {
                                    backgroundColor = Color("#4F5359")
                                    padding = Padding(2.px, 6.px)
                                    borderRadius = 10.px
                                    marginLeft = 10.px
                                    display = Display.inlineBlock
                                }
                                span {
                                    css {
                                        fontSize = 12.px
                                        fontWeight = FontWeight.bold
                                        color = NamedColor.white
                                    }
                                    +chat.unreadCount.toString()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}