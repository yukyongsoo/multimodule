package com.yuk.domain.book

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Embedded
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.ManyToOne

@Entity
class Chapter(
    @Embedded
    val content: Content,
    @ManyToOne(optional = false)
    val author: Author
) {
    @EmbeddedId
    val id = ChapterId()

    @ManyToOne(optional = true)
    var book: Book? = null
        get() = field
            ?: throw IllegalAccessException("chapter is not bind to book")
        protected set

    fun publish(book: Book) {
        this.book = book
    }
}

@Embeddable
class ChapterId(
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
) : Serializable {
    companion object {
        private const val serialVersionUID = 4272817937903452061L
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ChapterId

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
