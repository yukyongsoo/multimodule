package com.yuk.domain.money

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Currency(
    @Column(name = "currency_code")
    val code: String
)
