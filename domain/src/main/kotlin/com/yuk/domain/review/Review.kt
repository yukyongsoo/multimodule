package com.yuk.domain.review

import com.yuk.domain.book.Chapter
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class Review(
    @ManyToOne(optional = false)
    open val chapter: Chapter
) {
    @EmbeddedId
    var id = ReviewId()

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

@Embeddable
class ReviewId(
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
) : Serializable {
    companion object {
        private const val serialVersionUID = -4436264258009030037L
    }

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
