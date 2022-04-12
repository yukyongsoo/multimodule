package com.yuk.domain.book

import com.yuk.domain.review.Review

open class Chapter(
    open val bookId: BookId,
    open val authorId: AuthorId,
    open val content: Content,
) {
    open lateinit var id: ChapterId
        protected set

    open lateinit var book: Book
        protected set

    open lateinit var author: Author
        protected set
    open val reviews = mutableListOf<Review>()

    fun addReview(review: Review) {
        reviews.add(review)
    }
}

class ChapterId(
    protected val id: Long = 0
)
