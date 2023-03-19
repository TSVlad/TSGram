package common

data class Chat(
    var id: String,
    var name: String,
    var pictureRef: String,
    var lastMessage: String,
    var unreadCount: Int
)
