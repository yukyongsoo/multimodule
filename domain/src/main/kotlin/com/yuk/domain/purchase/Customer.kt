package com.yuk.domain.purchase

import com.yuk.domain.book.Book
import java.io.Serializable
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.OneToMany

@Entity
class Customer {

    @EmbeddedId
    var id = CustomerId()
        protected set

    @OneToMany(mappedBy = "customer", cascade = [CascadeType.ALL])
    val purchaseList = mutableListOf<PurchasedProduct>()

    fun buyBook(product: Product) {
        purchaseList.add(PurchasedProduct(product, this))
    }

    fun readBook(id: ProductId): Book {
        val purchasedProduct =
            purchaseList.find { it.product.id == id } ?: throw IllegalStateException("you not have book")

        return purchasedProduct.product.book
    }
}

@Embeddable
class CustomerId(
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
) : Serializable {
    companion object {
        private const val serialVersionUID = -7511434444401316158L
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CustomerId

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
