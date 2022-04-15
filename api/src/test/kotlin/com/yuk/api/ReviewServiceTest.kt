package com.yuk.api

import com.yuk.api.review.ReviewService
import com.yuk.domain.book.ChapterId
import com.yuk.domain.review.Comment
import com.yuk.domain.review.Review
import com.yuk.domain.review.ReviewId
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ReviewServiceTest {
    @Autowired
    private lateinit var reviewService: ReviewService

    @Test
    fun `리뷰 생성`() {
        val review = Review()
        review.addComment(Comment(review, "asdfasdf"))

        reviewService.addReview(review, ChapterId(1))
    }

    @Test
    fun `리뷰 승인`() {
        reviewService.approveReview(ReviewId(1))
    }

    @Test
    fun `리뷰 거절`() {
        reviewService.rejectReview(ReviewId(1))
    }
}
