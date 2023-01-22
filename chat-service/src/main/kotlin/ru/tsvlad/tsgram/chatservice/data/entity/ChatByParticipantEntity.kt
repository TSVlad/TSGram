package ru.tsvlad.tsgram.chatservice.data.entity

import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.util.*

@Table("chats_by_participant")
data class ChatByParticipantEntity(
    @PrimaryKey
    val chatByParticipantPk: ChatByParticipantPk
)
