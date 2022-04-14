package com.yuk.domain.book

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Content(
    @Column(nullable = false)
    val content: String
)
