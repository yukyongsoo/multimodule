package com.yuk.api.money

import com.yuk.domain.money.Currency
import com.yuk.domain.money.Exchanges
import com.yuk.domain.money.Money
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MoneyService(
    private val exchanges: Exchanges
) {
    fun exchange(money: Money, to: Currency): Money {
        val exchange = exchanges.findRate(money.currency, to)
            ?: throw IllegalArgumentException("no exchange rate")

        return exchange.convert(money)
    }
}
