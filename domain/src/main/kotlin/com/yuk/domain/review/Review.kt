package com.yuk.domain.review

import com.yuk.domain.book.Chapter

class Review(
    open val chapter: Chapter
) {
    open var id: ReviewId = ReviewId()

    open val comments = mutableListOf<Comment>()

    var approval = false
        private set

    fun addComment(comment: Comment) {
        comments.add(comment)
    }

    fun approve() {
        approval = true
    }

    fun reject() {
        approval = false
    }
}

class ReviewId(
    open val id: Long = 0
)