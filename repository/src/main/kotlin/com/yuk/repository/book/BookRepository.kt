package com.yuk.repository.book

import com.yuk.domain.book.Book
import com.yuk.domain.book.BookId
import com.yuk.domain.book.Books
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
internal class BookRepository(
    private val bookJpaRepository: BookJpaRepository
) : Books {
    override fun exist(id: BookId): Boolean {
        return bookJpaRepository.existsById(id.id)
    }

    override fun findById(bookId: BookId): Book? {
        return bookJpaRepository.findByIdOrNull(bookId.id)
    }
}

internal interface BookJpaRepository : JpaRepository<Book, Long>
