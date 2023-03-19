package common

data class Message(
    val id: String,
    val content: String,
    val timestamp: String,
    val isMine: Boolean
)
