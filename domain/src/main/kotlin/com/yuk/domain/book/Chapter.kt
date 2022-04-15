package com.yuk.domain.book

import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Chapter(
    @Embedded
    val content: Content,
    @ManyToOne(optional = false)
    val author: Author
) {
    @delegate:Transient
    val chapterId by lazy {
        ChapterId(id)
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long = 0

    @ManyToOne(optional = true)
    var book: Book? = null
        get() = field
            ?: throw IllegalAccessException("chapter is not bind to book")
        protected set

    fun publish(book: Book) {
        this.book = book
    }
}

class ChapterId(
    val id: Long
)
