package com.yuk.domain.book

abstract class Book(
    open val id: BookId
) {
    open val chapters = mutableListOf<Chapter>()
    open var beta = true
        protected set

    fun addChapter(chapter: Chapter) {
        chapters.add(chapter)
    }

    fun setOfficial() {
        beta = false
    }
}

class BookId(
    protected val id: Long = 0
)
