package com.yuk.domain.review

class Reviewer(
    private val reviews: MutableList<Review>
) {
    fun addReview(review: Review) {
        reviews.add(review)
    }
}
