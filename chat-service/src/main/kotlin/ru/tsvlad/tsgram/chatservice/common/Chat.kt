package ru.tsvlad.tsgram.chatservice.common

import java.util.UUID

data class Chat (
    var chatId: UUID,
    var name: String,
    var ownerUserId: UUID,
    var participantIds: List<UUID>
)