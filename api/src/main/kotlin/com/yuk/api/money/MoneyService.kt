package com.yuk.api.money

import com.yuk.domain.money.Exchanges
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MoneyService(
    private val exchanges: Exchanges
)
