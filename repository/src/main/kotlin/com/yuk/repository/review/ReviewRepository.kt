package com.yuk.repository.review

import com.yuk.domain.review.Review
import com.yuk.domain.review.ReviewId
import com.yuk.domain.review.Reviews
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
internal class ReviewRepository(
    private val reviewJpaRepository: ReviewJpaRepository
) : Reviews {
    override fun getReviews(): List<Review> {
        return reviewJpaRepository.findAll()
    }

    override fun findById(reviewId: ReviewId): Review? {
        return reviewJpaRepository.findByIdOrNull(reviewId.id)
    }

    override fun addReview(review: Review) {
        reviewJpaRepository.save(review)
    }
}

internal interface ReviewJpaRepository : JpaRepository<Review, Long>
