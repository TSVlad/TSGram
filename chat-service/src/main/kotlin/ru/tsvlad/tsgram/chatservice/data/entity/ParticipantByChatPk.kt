package ru.tsvlad.tsgram.chatservice.data.entity

import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn
import java.util.*

@PrimaryKeyClass
data class ParticipantByChatPk(
    @PrimaryKeyColumn(name = "chat_id", type = PrimaryKeyType.PARTITIONED)
    var chatId: UUID,
    @PrimaryKeyColumn(name = "participant_id", type = PrimaryKeyType.CLUSTERED)
    var participantId: UUID
)