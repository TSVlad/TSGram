package ru.tsvlad.tsgram.chatservice.data.entity

import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn
import java.util.*

@PrimaryKeyClass
data class ChatByParticipantPk (
    @PrimaryKeyColumn(name = "participant_id", type = PrimaryKeyType.PARTITIONED)
    var participantId: UUID,
    @PrimaryKeyColumn(name = "chat_id", type = PrimaryKeyType.CLUSTERED)
    var chatId: UUID
)