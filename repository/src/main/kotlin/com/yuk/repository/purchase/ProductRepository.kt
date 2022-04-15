package com.yuk.repository.purchase

import com.yuk.domain.book.BookId
import com.yuk.domain.purchase.Product
import com.yuk.domain.purchase.ProductId
import com.yuk.domain.purchase.Products
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
internal class ProductRepository(
    private val productJpaRepository: ProductJpaRepository
) : Products {
    override fun findById(id: ProductId): Product? {
        return productJpaRepository.findByIdOrNull(id.id)
    }

    override fun existByBookId(id: BookId): Boolean {
        return productJpaRepository.existsById(id.id)
    }

    override fun sale(product: Product) {
        productJpaRepository.save(product)
    }
}

internal interface ProductJpaRepository : JpaRepository<Product, Long>
