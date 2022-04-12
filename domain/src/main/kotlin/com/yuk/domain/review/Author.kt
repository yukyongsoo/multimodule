package com.yuk.domain.review

class Author {
    fun approveReview(review: Review) {
        review.approve()
    }

    fun rejectReview(review: Review) {
        review.reject()
    }
}
