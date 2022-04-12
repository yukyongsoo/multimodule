package com.yuk.api.purchase

import com.yuk.domain.publishing.ProductId
import com.yuk.domain.publishing.Products
import com.yuk.domain.purchase.CustomerId
import com.yuk.domain.purchase.Customers
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PurchaseService(
    private val customers: Customers,
    private val products: Products
) {
    fun purchase(customerId: CustomerId, productId: ProductId) {
        val customer = customers.findById(customerId) ?: throw IllegalArgumentException("customer not found")

        val product = products.findById(productId) ?: throw IllegalArgumentException("product not found")

        customer.buyBook(product)
    }
}