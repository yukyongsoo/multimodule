package com.yuk.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


interface DomainRepository: JpaRepository<DomainEntity, Long>