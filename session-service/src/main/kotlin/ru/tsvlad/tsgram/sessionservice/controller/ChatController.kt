package ru.tsvlad.tsgram.sessionservice.controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.simp.annotation.SubscribeMapping
import org.springframework.stereotype.Controller

@Controller
class ChatController(
    val messageTemplate : SimpMessagingTemplate
) {

    @MessageMapping("/topic/push")
    fun processMessage(@Payload message: String) {
        println(message)
        messageTemplate.convertAndSend("/topic/chat.name", message)
    }

    @SubscribeMapping("/topic/chat.name")
    fun subscription() {
        println("Subscription")
    }
}