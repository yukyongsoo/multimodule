package com.yuk.domain.video

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
