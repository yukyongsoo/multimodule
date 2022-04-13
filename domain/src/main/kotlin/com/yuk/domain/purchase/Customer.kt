package com.yuk.domain.purchase

import com.yuk.domain.book.Book


class Customer{
    open var id: CustomerId = CustomerId()
        protected set

    open val purchaseList = mutableListOf<PurchasedProduct>()

    fun buyBook(product: Product) {
        purchaseList.add(PurchasedProduct(product, this))
    }

    fun readBook(product: Product): Book {
        val purchasedProduct
            = purchaseList.find { it.product.id == product.id } ?: throw IllegalStateException("you not have book")

        return purchasedProduct.product.book
    }
}

class CustomerId(
    val id: Long = 0
)