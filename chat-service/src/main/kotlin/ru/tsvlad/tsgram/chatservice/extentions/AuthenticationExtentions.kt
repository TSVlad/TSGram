package ru.tsvlad.tsgram.chatservice.extentions

import org.springframework.security.core.Authentication
import java.util.UUID

fun Authentication.getUserId() : UUID {
    return UUID.fromString(this.name)
}