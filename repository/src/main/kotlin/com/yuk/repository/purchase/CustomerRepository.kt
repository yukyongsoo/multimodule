package com.yuk.repository.purchase

import com.yuk.domain.purchase.Customer
import com.yuk.domain.purchase.CustomerId
import com.yuk.domain.purchase.Customers
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
internal class CustomerRepository(
    private val customerJpaRepository: CustomerJpaRepository
) : Customers {
    override fun getCustomers(): List<Customer> {
        return customerJpaRepository.findAll()
    }

    override fun findById(id: CustomerId): Customer? {
        return customerJpaRepository.findByIdOrNull(id.id)
    }
}

internal interface CustomerJpaRepository : JpaRepository<Customer, Long>
