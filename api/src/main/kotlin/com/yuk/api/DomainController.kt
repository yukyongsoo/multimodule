package com.yuk.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DomainController(
    private val domainService: DomainService
) {
    @GetMapping
    fun getAll() = domainService.getAll()
}