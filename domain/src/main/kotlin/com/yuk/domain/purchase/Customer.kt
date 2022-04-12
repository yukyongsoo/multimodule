package com.yuk.domain.purchase

import com.yuk.domain.book.Book
import com.yuk.domain.publishing.Product
import com.yuk.domain.publishing.ProductId


class Customer(
    protected val id: CustomerId
) {
    private val purchaseList = mutableListOf<Product>()

    fun buyBook(product: Product) {
        purchaseList.add(product)
    }

    fun readBook(productId: ProductId): Book {
        return purchaseList.find { it.id == productId }?.book ?: throw IllegalStateException("you not have book")
    }
}

class CustomerId(
    val id: Long = 0
)