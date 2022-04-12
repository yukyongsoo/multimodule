package com.yuk.domain.book

interface Books {
    fun getBooks(): List<Book>
    fun addBook(book: Book)
    fun findById(bookId: BookId): Book?
    fun exist(id: BookId): Boolean
}
