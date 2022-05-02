package com.yuk.domain.money

interface Exchanges {
    fun findRate(from: Currency, to: Currency): Exchange?
}
