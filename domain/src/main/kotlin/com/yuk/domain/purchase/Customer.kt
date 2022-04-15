package com.yuk.domain.purchase

import com.yuk.domain.book.Book
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Customer {
    val customerId
        get() = CustomerId(id)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @OneToMany(mappedBy = "customer", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    val purchaseList = mutableListOf<PurchasedProduct>()

    fun buyBook(product: Product) {
        purchaseList.add(PurchasedProduct(product, this))
    }

    fun readBook(id: ProductId): Book {
        val purchasedProduct =
            purchaseList.find { it.product.productId == id } ?: throw IllegalStateException("you not have book")

        return purchasedProduct.product.book
    }
}

class CustomerId(
    val id: Long
) {
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
