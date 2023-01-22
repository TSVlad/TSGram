package ru.tsvlad.tsgram.chatservice.component.service.impl

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import ru.tsvlad.tsgram.chatservice.common.Chat
import ru.tsvlad.tsgram.chatservice.component.mapper.ChatMapper
import ru.tsvlad.tsgram.chatservice.component.service.ChatService
import ru.tsvlad.tsgram.chatservice.data.entity.*
import ru.tsvlad.tsgram.chatservice.data.repository.ChatByParticipantRepository
import ru.tsvlad.tsgram.chatservice.data.repository.ChatRepository
import ru.tsvlad.tsgram.chatservice.data.repository.ParticipantByChatRepository
import ru.tsvlad.tsgram.commons.exceptions.ForbiddenException
import java.util.UUID

@Service
class ChatServiceImpl(
    val chatRepository: ChatRepository,
    val chatByParticipantRepository: ChatByParticipantRepository,
    val participantByChatRepository: ParticipantByChatRepository,
    val chatMapper: ChatMapper
) : ChatService {
    override fun createChat(chatName: String, ownerId: UUID): Mono<Chat> {
        return chatRepository.insert(ChatEntity(UUID.randomUUID(), chatName, ownerId))
            .flatMap { chatEntity: ChatEntity ->
                addParticipant(chatEntity.chatId, ownerId)
                    .map {
                        chatMapper.entityToChat(chatEntity, listOf(it))
                    }
            }
    }

    override fun addParticipant(chatId: UUID, userId: UUID, requesterUserId: UUID): Mono<Void> {
        return chatRepository.findById(chatId)
            .flatMap { chatEntity: ChatEntity ->
                if (requesterUserId == chatEntity.ownerUserId) {
                    return@flatMap addParticipant(chatId, userId)
                } else {
                    return@flatMap Mono.error(ForbiddenException())
                }
            }
            .then()
    }

    private fun addParticipant(chatId: UUID, participantId: UUID): Mono<ParticipantByChatEntity> {
        return chatByParticipantRepository.insert(ChatByParticipantEntity(ChatByParticipantPk(participantId, chatId)))
            .then(
                participantByChatRepository.insert(
                    ParticipantByChatEntity(
                        ParticipantByChatPk(
                            chatId,
                            participantId
                        )
                    )
                )
            )
    }

    override fun getChatsByParticipants(participantIds: List<UUID>): Flux<Chat> {
        return chatByParticipantRepository.findAllByChatByParticipantPkParticipantIdIn(participantIds)
            .collectList()
            .flatMapMany { chatByParticipantEntities ->
                chatRepository.findAllById(
                    chatByParticipantEntities.stream().map { it.chatByParticipantPk.chatId }.toList()
                ).collectList()
                    .flatMapMany { chatEntities ->
                        participantByChatRepository.findAllByParticipantByChatPkChatIdIn(
                            chatEntities.stream().map { it.chatId }.toList()
                        ).collectMultimap { it.participantByChatPk.chatId }.flatMapMany { map: MutableMap<UUID, MutableCollection<ParticipantByChatEntity>> ->
                            Flux.fromIterable(chatEntities).map { chatMapper.entityToChat(it, map.getOrDefault(it.chatId, mutableListOf())) }
                        }
                    }
            }
    }
}