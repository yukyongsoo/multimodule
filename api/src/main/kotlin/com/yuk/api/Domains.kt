package com.yuk.api

import com.yuk.repository.DomainRepository
import org.springframework.stereotype.Service

@Service
class Domains(private val domainRepository: DomainRepository) {
    fun getAll() = domainRepository.findAll()
}