package ru.tsvlad.tsgram.chatservice.data.repository

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository
import reactor.core.publisher.Flux
import ru.tsvlad.tsgram.chatservice.data.entity.ChatByParticipantEntity
import ru.tsvlad.tsgram.chatservice.data.entity.ChatByParticipantPk
import java.util.UUID

interface ChatByParticipantRepository : ReactiveCassandraRepository<ChatByParticipantEntity, ChatByParticipantPk> {
    fun findAllByChatByParticipantPkParticipantIdIn(participantIds: Collection<UUID>) : Flux<ChatByParticipantEntity>
}