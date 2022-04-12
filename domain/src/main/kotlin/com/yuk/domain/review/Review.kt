package com.yuk.domain.review

import com.yuk.domain.book.Chapter

class Review(
    open val id: ReviewId
) {
    open val comments = mutableListOf<Comment>()
    open lateinit var chapter: Chapter
        protected set

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
    open val id: Long
)