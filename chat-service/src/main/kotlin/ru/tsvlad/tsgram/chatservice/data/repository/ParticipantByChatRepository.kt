package ru.tsvlad.tsgram.chatservice.data.repository

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository
import reactor.core.publisher.Flux
import ru.tsvlad.tsgram.chatservice.data.entity.ParticipantByChatEntity
import ru.tsvlad.tsgram.chatservice.data.entity.ParticipantByChatPk
import java.util.UUID

interface ParticipantByChatRepository : ReactiveCassandraRepository<ParticipantByChatEntity, ParticipantByChatPk> {
    fun findAllByParticipantByChatPkChatIdIn(chatIds: Collection<UUID>) : Flux<ParticipantByChatEntity>
}