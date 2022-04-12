package com.yuk.domain.book

open class Author(
    open val authorId: AuthorId,
) {
    open val publishedChapters = mutableListOf<Chapter>()

    fun publish(chapter: Chapter) {
        publishedChapters.add(chapter)
    }
}

class AuthorId(
    private val id: Long
)