package com.yuk.repository.review

import com.yuk.domain.book.ChapterId
import com.yuk.domain.review.Review
import com.yuk.domain.review.ReviewId
import com.yuk.domain.review.Reviews
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
internal class ReviewRepository : Reviews {
    override fun getReviews(): List<Review> {
        TODO("Not yet implemented")
    }

    override fun findAllByChapterId(chapterId: ChapterId): List<Review> {
        TODO("Not yet implemented")
    }

    override fun findById(reviewId: ReviewId): Review? {
        TODO("Not yet implemented")
    }

    override fun addReview(review: Review) {
        TODO("Not yet implemented")
    }
}

internal interface ReviewJpaRepository : JpaRepository<Review, Long>
