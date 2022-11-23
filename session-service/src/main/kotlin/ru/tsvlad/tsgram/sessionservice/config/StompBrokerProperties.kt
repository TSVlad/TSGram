package ru.tsvlad.tsgram.sessionservice.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "stomp.broker")
class StompBrokerProperties(
    var host: String = "",
    var port: Int = 0,
    var login: String = "",
    var password: String = ""
)