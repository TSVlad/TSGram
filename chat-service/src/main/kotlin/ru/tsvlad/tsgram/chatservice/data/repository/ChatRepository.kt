package ru.tsvlad.tsgram.chatservice.data.repository

import org.springframework.data.cassandra.repository.Query
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository
import org.springframework.data.repository.query.Param
import reactor.core.publisher.Mono
import ru.tsvlad.tsgram.chatservice.data.entity.ChatEntity
import java.util.UUID

interface ChatRepository : ReactiveCassandraRepository<ChatEntity, UUID> {
}