package com.yuk.domain.book

interface Books {
    fun exist(id: BookId): Boolean
    fun findById(bookId: BookId): Book?
}
