package com.yuk.api.publishing

import com.yuk.domain.book.BookId
import com.yuk.domain.book.Books
import com.yuk.domain.book.Chapter
import com.yuk.domain.publishing.Product
import com.yuk.domain.publishing.Products
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PublishingService(
    private val products: Products,
    private val books: Books
) {
    fun getSaleList(): List<Product> {
        return products.getSaleList()
    }

    fun publishBook(id: BookId) {
        if(books.exist(id))
            throw IllegalArgumentException("book not found")

        if(products.existByBookId(id))
            throw IllegalArgumentException("book already published")

        products.sale(id)
    }

    fun publishChapter(chapter: Chapter) {
        val book = books.findById(chapter.bookId) ?: throw IllegalArgumentException("book not found")

        book.addChapter(chapter)
    }
}