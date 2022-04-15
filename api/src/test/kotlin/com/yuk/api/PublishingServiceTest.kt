package com.yuk.api

import com.yuk.api.publishing.PublishingService
import com.yuk.domain.book.Author
import com.yuk.domain.book.BookId
import com.yuk.domain.book.Chapter
import com.yuk.domain.book.ChapterId
import com.yuk.domain.book.Content
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PublishingServiceTest {
    @Autowired
    private lateinit var publishingService: PublishingService

    @Test
    fun `책 출판`() {
        publishingService.publishBook(BookId(1))
    }

    @Test
    fun `책에서 챕터 출간`() {
        publishingService.publishChapter(ChapterId(1), BookId(1))
    }

    @Test
    fun `작가가 챕터 출간`() {
        val chapter = Chapter(Content("asdfsadf"), Author(1))

        publishingService.createChapter(chapter)
    }
}
