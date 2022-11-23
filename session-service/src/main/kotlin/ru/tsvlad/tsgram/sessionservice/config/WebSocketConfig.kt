package ru.tsvlad.tsgram.sessionservice.config

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.converter.MessageConverter
import org.springframework.messaging.converter.StringMessageConverter
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig(val stompBrokerProperties: StompBrokerProperties) : WebSocketMessageBrokerConfigurer {

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/ws")
            .setAllowedOriginPatterns("*")
            .withSockJS()
    }

    override fun configureMessageConverters(messageConverters: MutableList<MessageConverter>): Boolean {
        messageConverters.add(StringMessageConverter())
        return false
    }

    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry.enableStompBrokerRelay("/topic")
            .setRelayHost(stompBrokerProperties.host)
            .setVirtualHost("/")
            .setRelayPort(stompBrokerProperties.port)
            .setClientLogin(stompBrokerProperties.login)
            .setClientPasscode(stompBrokerProperties.password)
            .setSystemLogin(stompBrokerProperties.login)
            .setSystemPasscode(stompBrokerProperties.password);
//        registry.setApplicationDestinationPrefixes("/app")
//        registry.setUserDestinationPrefix("/user")
    }
}