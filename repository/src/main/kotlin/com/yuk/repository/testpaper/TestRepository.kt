package com.yuk.repository.testpaper

import com.yuk.domain.testpaper.Test
import com.yuk.domain.testpaper.TestId
import com.yuk.domain.testpaper.Tests
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
internal class TestRepository(
    private val testJpaRepository: TestJpaRepository
) : Tests {
    override fun findById(testId: TestId): Test? {
        return testJpaRepository.findByIdOrNull(testId.id)
    }
}

internal interface TestJpaRepository : JpaRepository<Test, Long>
