package com.yuk.repository.money

import com.yuk.domain.money.Currency
import com.yuk.domain.money.Exchange
import com.yuk.domain.money.Exchanges
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
internal class ExchangeRepository(
    private val exchangeJPARepository: ExchangeJPARepository
) : Exchanges {
    override fun findRate(from: Currency, to: Currency): Exchange? {
        return exchangeJPARepository.findByFromAndTo(from, to)
    }
}

internal interface ExchangeJPARepository : JpaRepository<Exchange, Int> {
    fun findByFromAndTo(from: Currency, to: Currency): Exchange?
}
