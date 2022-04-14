package com.yuk.domain.book

import com.yuk.domain.purchase.Product
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.DiscriminatorColumn
import javax.persistence.Embeddable
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.OneToMany
import javax.persistence.OneToOne

@Entity
@DiscriminatorColumn(name = "type", columnDefinition = "TINYINT")
abstract class Book {
    @EmbeddedId
    val id = BookId()

    @Column(nullable = false)
    var beta = true
        protected set

    @OneToMany(mappedBy = "book")
    val chapters = mutableListOf<Chapter>()

    @OneToOne(optional = true, mappedBy = "book")
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

@Embeddable
class BookId(
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
) : Serializable {
    companion object {
        private const val serialVersionUID = 132908243487197476L
    }

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
