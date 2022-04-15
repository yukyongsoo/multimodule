package com.yuk.domain.review

interface Reviews {
    fun getReviews(): List<Review>
    fun findById(reviewId: ReviewId): Review?
    fun addReview(review: Review)
}
