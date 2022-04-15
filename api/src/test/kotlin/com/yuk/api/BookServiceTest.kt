package com.yuk.api

import com.yuk.api.book.BookService
import com.yuk.domain.purchase.CustomerId
import com.yuk.domain.purchase.ProductId
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookServiceTest {
    @Autowired
    private lateinit var bookService: BookService

    @Test
    fun `책 읽기`() {
        bookService.readBook(ProductId(1), CustomerId(1))
    }
}
