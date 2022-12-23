package ru.tsvlad.tsgram.commons.exceptions

class NotFoundException(override val message: String?) : RuntimeException(message) {

}