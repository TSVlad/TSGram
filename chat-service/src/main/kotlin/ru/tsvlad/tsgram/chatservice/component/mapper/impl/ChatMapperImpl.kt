package ru.tsvlad.tsgram.chatservice.component.mapper.impl

import org.springframework.stereotype.Component
import ru.tsvlad.tsgram.chatservice.common.Chat
import ru.tsvlad.tsgram.chatservice.component.mapper.ChatMapper
import ru.tsvlad.tsgram.chatservice.data.entity.ChatEntity
import ru.tsvlad.tsgram.chatservice.data.entity.ParticipantByChatEntity

@Component
class ChatMapperImpl : ChatMapper {
    override fun entityToChat(chatEntity: ChatEntity, participantByChatEntities: Collection<ParticipantByChatEntity>) : Chat {
        return Chat(chatEntity.chatId, chatEntity.name, chatEntity.ownerUserId,
            participantByChatEntities.stream().map { it.participantByChatPk.participantId }.toList())
    }
}