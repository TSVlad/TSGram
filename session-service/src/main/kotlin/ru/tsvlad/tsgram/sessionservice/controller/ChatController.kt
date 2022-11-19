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

    @MessageMapping("/push")
    fun processMessage(@Payload message: String) {
        println(message)
        messageTemplate.convertAndSend("/client/chat/name", message)
    }

    @SubscribeMapping("/client/chat/name")
    fun subscription() {
        println("Subscription")
    }
}