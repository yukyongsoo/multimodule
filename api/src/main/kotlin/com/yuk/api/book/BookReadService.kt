package com.yuk.api.book

import com.yuk.domain.book.Book
import com.yuk.domain.purchase.ProductId
import com.yuk.domain.purchase.CustomerId
import com.yuk.domain.purchase.Customers
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class BookReadService(
    private val products: Products,
    private val customers: Customers
) {
    fun readBook(productId: ProductId, customerId: CustomerId): Book {
        val customer = customers.findById(customerId) ?: throw IllegalArgumentException("customer not found")

        return customer.readBook(productId)
    }
}