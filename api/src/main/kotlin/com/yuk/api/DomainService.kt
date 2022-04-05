package com.yuk.api

import com.yuk.domain.Domain
import com.yuk.domain.Domains
import org.springframework.stereotype.Service

@Service
class DomainService(
    private val domains: Domains
) {
    fun getAll(): List<Domain> {
        return domains.all()
    }
}