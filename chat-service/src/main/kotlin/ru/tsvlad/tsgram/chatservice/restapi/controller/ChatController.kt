package ru.tsvlad.tsgram.chatservice.restapi.controller

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import ru.tsvlad.tsgram.chatservice.common.Chat
import ru.tsvlad.tsgram.chatservice.component.service.ChatService
import ru.tsvlad.tsgram.chatservice.extentions.getUserId
import java.util.*

@RestController
@RequestMapping("/chats")
class ChatController(
    val chatService: ChatService
) {

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    fun createChat(@RequestParam name: String, authentication: Authentication) : Mono<Chat> {
        return chatService.createChat(name, authentication.getUserId())
    }

    @PostMapping("/{chatId}/participants")
    @PreAuthorize("isAuthenticated()")
    fun addUser(@PathVariable chatId: UUID, @RequestParam participantId: UUID, authentication: Authentication) : Mono<Void> {
        return chatService.addParticipant(chatId, participantId, authentication.getUserId())
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    fun getUsersChats(authentication: Authentication) : Flux<Chat> {
        return chatService.getChatsByParticipants(listOf(authentication.getUserId()))
    }
}