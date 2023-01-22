package ru.tsvlad.tsgram.chatservice.data.entity

import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.util.*

@Table("participants_by_chat")
class ParticipantByChatEntity(
    @PrimaryKey("chat_id")
    var participantByChatPk: ParticipantByChatPk
)