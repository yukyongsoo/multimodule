package com.yuk.domain.vidio

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class URL(
    @Column
    val url: String
) {
    companion object {
        val EMPTY = URL("")
    }
}