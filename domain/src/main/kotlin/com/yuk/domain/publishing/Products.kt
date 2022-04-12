package com.yuk.domain.publishing

import com.yuk.domain.book.BookId

interface Products {
    fun getSaleList(): List<Product>
    fun sale(id: BookId)
    fun findById(productId: ProductId): Product?
    fun existByBookId(id: BookId): Boolean
}
