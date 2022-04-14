package com.yuk.domain.purchase

import com.yuk.domain.book.Book
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.OneToOne

@Entity
class Product(
    @OneToOne(optional = false)
    open val book: Book
) {
    @EmbeddedId
    var id = ProductId()
        protected set
}

@Embeddable
class ProductId(
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
) : Serializable {
    companion object {
        private const val serialVersionUID = -1567129780357095569L
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProductId

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
