package com.yuk.api.review

import com.yuk.domain.review.Review
import com.yuk.domain.review.ReviewId
import com.yuk.domain.review.Reviews
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ReviewService(
    private val reviews: Reviews
) {
    fun addReview(review: Review) {
        reviews.addReview(review)
    }

    fun rejectReview(reviewId: ReviewId) {
        val review = reviews.findById(reviewId) ?: throw IllegalArgumentException("존재하지 않는 리뷰입니다.")

        review.reject()
    }

    fun approveReview(reviewId: ReviewId) {
        val review = reviews.findById(reviewId) ?: throw IllegalArgumentException("존재하지 않는 리뷰입니다.")

        review.approve()
    }
}
