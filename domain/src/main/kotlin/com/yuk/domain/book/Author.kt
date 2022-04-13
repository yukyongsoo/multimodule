package com.yuk.domain.book

open class Author(
    open val authorId: AuthorId,
)

class AuthorId(
    private val id: Long
)