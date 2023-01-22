package ru.tsvlad.tsgram.chatservice.restapi.controller.advice

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import ru.tsvlad.tsgram.commons.exceptions.ForbiddenException

@ControllerAdvice
class ErrorsHandler {

    @ExceptionHandler(ForbiddenException::class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    fun handleForbidden(e: ForbiddenException) {}
}