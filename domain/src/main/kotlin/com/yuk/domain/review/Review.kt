package com.yuk.domain.review

import com.yuk.domain.book.Chapter
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class Review(
    @ManyToOne(optional = false)
    open val chapter: Chapter
) {
    @delegate:Transient
    val reviewId by lazy {
        ReviewId(id)
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long = 0

    @OneToMany(mappedBy = "review")
    val comments = mutableListOf<Comment>()

    @Column(nullable = false)
    var approval = false
        protected set

    fun addComment(comment: Comment) {
        comments.add(comment)
        comment.associateReview(this)
    }

    fun approve() {
        approval = true
    }

    fun reject() {
        approval = false
    }
}

class ReviewId(
    val id: Long = 0
)
