package ru.tsvlad.tsgram.commons

import java.util.function.Function

data class Page<T> (
    val data : List<T>,
    val page : Int,
    val size : Int,
    val totalPages : Int
) {
    fun <R> map(function: Function<T, R>) : Page<R> {
        return Page(data.stream().map(function).toList(), page, size, totalPages)
    }
}