package com.yuk.domain.review

import com.yuk.domain.book.Chapter
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class Review {
    val reviewId
        get() = ReviewId(id)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long = 0

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    var chapter: Chapter? = null

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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ReviewId

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
