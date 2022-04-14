package com.yuk.domain.purchase

import com.yuk.domain.book.BookId

interface Products {
    fun findById(id: ProductId): Product?
    fun existByBookId(id: BookId): Boolean
    fun sale(id: BookId)
}
