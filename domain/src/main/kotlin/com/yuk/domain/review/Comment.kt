package com.yuk.domain.review

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Comment(
    review: Review,
    @Column(nullable = false)
    val content: String
) {
    @delegate:Transient
    val commentId by lazy {
        CommentId(id)
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @ManyToOne
    var review: Review = review
        protected set

    fun associateReview(review: Review) {
        this.review = review
    }
}

class CommentId(
    val id: Long
)
