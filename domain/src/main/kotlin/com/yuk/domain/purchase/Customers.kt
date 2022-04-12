package com.yuk.domain.purchase

interface Customers {
    fun getCustomers(): List<Customer>
    fun findById(id: CustomerId): Customer?
}
