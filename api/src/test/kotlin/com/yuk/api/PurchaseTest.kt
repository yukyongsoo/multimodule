package com.yuk.api

import com.yuk.api.purchase.PurchaseService
import com.yuk.domain.purchase.CustomerId
import com.yuk.domain.purchase.ProductId
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PurchaseTest {
    @Autowired
    private lateinit var purchaseService: PurchaseService

    @Test
    fun `책 구입`() {
        purchaseService.purchase(CustomerId(1), ProductId(1))
    }
}
