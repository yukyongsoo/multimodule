package com.yuk.api.publishing

import com.yuk.domain.book.BookId
import com.yuk.domain.book.Books
import com.yuk.domain.book.Chapter
import com.yuk.domain.book.ChapterId
import com.yuk.domain.book.Chapters
import com.yuk.domain.purchase.Product
import com.yuk.domain.purchase.Products
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PublishingService(
    private val books: Books,
    private val products: Products,
    private val chapters: Chapters
) {
    fun publishBook(id: BookId) {
        val book = books.findById(id)
            ?: throw IllegalArgumentException("book not found")

        if (products.existByBookId(id))
            throw IllegalArgumentException("book already published")

        products.sale(Product(book))
    }

    fun publishChapter(chapterId: ChapterId, bookId: BookId) {
        val book = books.findById(bookId) ?: throw IllegalArgumentException("book not found")

        val chapter = chapters.findById(chapterId) ?: throw IllegalArgumentException("chapter not found")

        book.addChapter(chapter)
    }

    fun createChapter(chapter: Chapter) {
        chapters.create(chapter)
    }
}
