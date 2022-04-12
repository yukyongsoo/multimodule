package com.yuk.domain.review

import com.yuk.domain.book.ChapterId

interface Reviews {
    fun getReviews(): List<Review>
    fun findAllByChapterId(chapterId: ChapterId): List<Review>
    fun findById(reviewId: ReviewId): Review?
    fun addReview(review: Review)
}
