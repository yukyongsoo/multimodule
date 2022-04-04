package com.yuk.api

import org.springframework.web.bind.annotation.RestController

@RestController
class DomainController(
    private val domainService: DomainService
) {
    fun getAll() = domainService.getAll()
}