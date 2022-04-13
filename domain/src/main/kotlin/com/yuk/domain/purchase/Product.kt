package com.yuk.domain.purchase

import com.yuk.domain.book.Book

open class Product(
    open val book: Book
) {
    open var id: ProductId = ProductId()
        protected set
}

class ProductId(
    open val id: Long = 0
)
