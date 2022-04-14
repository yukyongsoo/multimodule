package com.yuk.domain.book

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Author(
    authorId: AuthorId
) {
    @Transient
    final var authorId = authorId
        private set(value) {
            id = value.id
            field = value
        }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null
        set(value) {
            value?.let {
                authorId = AuthorId(it)
            }
            field = value
        }
}

class AuthorId(
    val id: Long = 0
)