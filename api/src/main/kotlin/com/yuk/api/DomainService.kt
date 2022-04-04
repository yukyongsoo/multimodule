package com.yuk.api

import com.yuk.domain.Domain
import org.springframework.stereotype.Service

@Service
class DomainService(
    private val domains: Domains
) {
    fun getAll(): List<Domain> {
        return domains.getAll()
    }
}