package com.yuk.repository

import org.springframework.data.jpa.repository.JpaRepository


interface DomainRepository: JpaRepository<DomainEntity, Long>