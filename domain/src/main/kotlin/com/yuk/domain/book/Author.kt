package com.yuk.domain.book

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Author {
    @delegate:Transient
    val authorId by lazy {
        AuthorId(id)
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long = 0
}

class AuthorId(
    val id: Long
)
