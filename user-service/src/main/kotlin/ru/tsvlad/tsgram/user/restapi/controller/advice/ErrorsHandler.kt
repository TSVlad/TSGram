package ru.tsvlad.tsgram.user.restapi.controller.advice

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import ru.tsvlad.tsgram.commons.exceptions.NotFoundException

@ControllerAdvice
class ErrorsHandler {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFound(notFoundException: NotFoundException) : ResponseEntity<ErrorResponse>{
        return generateResponse(HttpStatus.NOT_FOUND, notFoundException.message)
    }

    private fun generateResponse(httpStatus: HttpStatus, message: String?) : ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse(httpStatus.value(), message), httpStatus)
    }
}