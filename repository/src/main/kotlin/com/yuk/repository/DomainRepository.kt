package com.yuk.repository

import com.yuk.domain.Domain
import com.yuk.domain.Domains
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Service

internal interface DomainRepository : JpaRepository<DomainEntity, Long>

@Service
internal class DomainQueryDslRepository(
    private val domainRepository: DomainRepository
) : Domains, QuerydslRepositorySupport(DomainEntity::class.java) {
    override fun all(): List<Domain> {
        return domainRepository.findAll()
    }


}