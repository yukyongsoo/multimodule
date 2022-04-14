package com.yuk.repository.purchase

import com.yuk.domain.book.BookId
import com.yuk.domain.purchase.Product
import com.yuk.domain.purchase.ProductId
import com.yuk.domain.purchase.Products
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
internal class ProductRepository(
    private val productJpaRepository: ProductJpaRepository
) : Products {
    override fun findById(id: ProductId): Product? {
        TODO("Not yet implemented")
    }

    override fun existByBookId(id: BookId): Boolean {
        TODO("Not yet implemented")
    }

    override fun sale(id: BookId) {
        TODO("Not yet implemented")
    }
}

internal interface ProductJpaRepository : JpaRepository<Product, ProductId>
