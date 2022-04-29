package com.yuk.domain.money

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Embedded

@Embeddable
class Money(
    @Column
    val amount: Long,
    @Embedded
    val currency: Currency
) {
    companion object {
        val ZERO = Money(0, Currency("USD"))
    }
}
