package ru.tsvlad.tsgram.chatservice.component.mapper

import ru.tsvlad.tsgram.chatservice.common.Chat
import ru.tsvlad.tsgram.chatservice.data.entity.ChatEntity
import ru.tsvlad.tsgram.chatservice.data.entity.ParticipantByChatEntity

interface ChatMapper {
    fun entityToChat(chatEntity: ChatEntity, participantByChatEntities: Collection<ParticipantByChatEntity>) : Chat;
}