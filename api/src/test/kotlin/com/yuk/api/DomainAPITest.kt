package com.yuk.api

import com.yuk.domain.Domain
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class DomainAPITest {
    @Autowired
    private lateinit var webTestClient: WebTestClient

    @Test
    fun `도메인 전체 불러오기`() {
        webTestClient.get().uri("")
            .exchange()
            .expectStatus().isOk
            .expectBody<List<Domain>>()
    }
}
