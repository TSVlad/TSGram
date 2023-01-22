package ru.tsvlad.tsgram.chatservice.data.entity

import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.util.UUID

@Table("chats")
data class ChatEntity(
    @PrimaryKey("chat_id")
    var chatId: UUID,
    @field:Column("name")
    var name: String,
    @field:Column("owner_user_id")
    var ownerUserId: UUID
)
