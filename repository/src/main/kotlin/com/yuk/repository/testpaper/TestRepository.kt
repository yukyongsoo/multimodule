package com.yuk.repository.testpaper

import com.yuk.domain.testpaper.Test
import com.yuk.domain.testpaper.Tests
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class TestRepository(
    private val testJpaRepository: TestJpaRepository
) : Tests

interface TestJpaRepository : JpaRepository<Test, Long>
