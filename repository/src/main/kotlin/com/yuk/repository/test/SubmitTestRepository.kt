package com.yuk.repository.test

import com.yuk.domain.test.SubmitTest
import com.yuk.domain.test.SubmitTestId
import com.yuk.domain.test.SubmitTests
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
internal class SubmitTestRepository(
    private val submitTestJpaRepository: SubmitTestJpaRepository
) : SubmitTests {
    override fun submit(submitTest: SubmitTest) {
        submitTestJpaRepository.save(submitTest)
    }

    override fun findById(submitTestId: SubmitTestId): SubmitTest? {
        return submitTestJpaRepository.findByIdOrNull(submitTestId.id)
    }
}

internal interface SubmitTestJpaRepository : JpaRepository<SubmitTest, Long>
