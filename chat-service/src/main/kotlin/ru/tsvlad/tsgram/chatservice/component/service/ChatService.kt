package ru.tsvlad.tsgram.chatservice.component.service

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import ru.tsvlad.tsgram.chatservice.common.Chat
import ru.tsvlad.tsgram.chatservice.data.entity.ParticipantByChatEntity
import java.util.UUID

interface ChatService {
    fun createChat(chatName: String, ownerId: UUID) : Mono<Chat>

    fun addParticipant(chatId: UUID, userId: UUID, requesterUserId: UUID) : Mono<Void>

    fun getChatsByParticipants(participantIds: List<UUID>) : Flux<Chat>
}