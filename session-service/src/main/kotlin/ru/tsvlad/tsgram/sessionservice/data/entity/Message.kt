package ru.tsvlad.tsgram.sessionservice.data.entity

import org.springframework.data.cassandra.core.mapping.Table
import java.time.OffsetDateTime

@Table
data class Message(
    val chatId : String,
    val messageId : String,
    val senderUserId : String,
    val datetime : OffsetDateTime,
    val content : String
)
