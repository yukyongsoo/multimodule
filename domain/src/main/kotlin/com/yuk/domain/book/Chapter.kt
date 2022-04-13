package com.yuk.domain.book

open class Chapter(
    open val content: Content,
    open val author: Author
) {
    open val id: ChapterId = ChapterId()

    open var book: Book? = null
        get() = field ?: throw IllegalAccessException("chapter is not bind to book")
        protected set

    fun publish(book: Book) {
        this.book = book
    }
}

open class ChapterId(
    protected open val id: Long = 0
)
