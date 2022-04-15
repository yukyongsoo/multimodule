package com.yuk.domain.purchase

import com.yuk.domain.book.Book
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Customer {
    @delegate:Transient
    val customerId by lazy {
        CustomerId(id)
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

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

class CustomerId(
    val id: Long
)
