package com.yuk.domain.book

import com.yuk.domain.purchase.Product

abstract class Book{
    open val id: BookId = BookId()

    open val chapters: MutableList<Chapter> = mutableListOf()

    open var beta = true
        protected set

    open var product: Product? = null
        get() = field ?: throw IllegalAccessException("book not sale")
        protected set

    fun addChapter(chapter: Chapter) {
        chapters.add(chapter)
    }

    fun setOfficial() {
        beta = false
    }

    fun publish(product: Product) {
        this.product = product
    }
}

open class BookId(
    protected open val id: Long = 0
)
