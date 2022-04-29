package com.yuk.repository.money

import com.yuk.domain.money.Exchange
import com.yuk.domain.money.Exchanges
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
internal class ExchangeRepository(
    private val exchangeJPARepository: ExchangeJPARepository
) : Exchanges

internal interface ExchangeJPARepository : JpaRepository<Exchange, Int>
