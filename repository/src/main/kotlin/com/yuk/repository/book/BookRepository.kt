package com.yuk.repository.book

import com.yuk.domain.book.Books
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : Books, JpaRepository<BookEntity, BookEntityId>