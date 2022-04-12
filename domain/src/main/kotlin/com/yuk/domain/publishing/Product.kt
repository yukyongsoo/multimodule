package com.yuk.domain.publishing

import com.yuk.domain.book.Book

class Product(
    open val id: ProductId,
) {
    open lateinit var book: Book
        protected set
}

class ProductId(
    open val id: Long
)
