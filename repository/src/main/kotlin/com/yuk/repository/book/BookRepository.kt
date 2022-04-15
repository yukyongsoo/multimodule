package com.yuk.repository.book

import com.yuk.domain.book.Book
import com.yuk.domain.book.BookId
import com.yuk.domain.book.Books
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
internal class BookRepository(
    private val bookJpaRepository: BookJpaRepository
) : Books {
    override fun exist(id: BookId): Boolean {
        TODO("Not yet implemented")
    }

    override fun findById(bookId: Any): Book? {
        TODO("Not yet implemented")
    }
}

internal interface BookJpaRepository : JpaRepository<Book, Long>
