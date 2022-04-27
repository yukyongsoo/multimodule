package com.yuk.domain.auction

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Category(
    @Column
    val value: String
) {
    companion object {
        val EMPTY = Category("")
    }
}