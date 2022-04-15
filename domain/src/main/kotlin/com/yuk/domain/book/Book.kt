package com.yuk.domain.book

import com.yuk.domain.purchase.Product
import javax.persistence.Column
import javax.persistence.DiscriminatorColumn
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.OneToOne

@Entity
@DiscriminatorColumn(name = "type", columnDefinition = "TINYINT")
abstract class Book {
    val bookId
        get() = BookId(id)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long = 0

    @Column(nullable = false)
    var beta = true
        protected set

    @OneToMany(mappedBy = "book")
    val chapters = mutableListOf<Chapter>()

    @OneToOne(optional = true, mappedBy = "book", fetch = FetchType.LAZY)
    var product: Product? = null
        get() = field ?: throw IllegalAccessException("book not sale")
        protected set

    fun addChapter(chapter: Chapter) {
        chapters.add(chapter)
        chapter.publish(this)
    }

    fun setOfficial() {
        beta = false
    }

    fun publish(product: Product) {
        this.product = product
    }
}

class BookId(
    val id: Long
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BookId

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
