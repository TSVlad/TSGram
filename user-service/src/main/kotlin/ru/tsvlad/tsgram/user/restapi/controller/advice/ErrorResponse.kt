package ru.tsvlad.tsgram.user.restapi.controller.advice

import org.springframework.http.HttpStatus

data class ErrorResponse(
    var status: Int,
    var message: String?
)