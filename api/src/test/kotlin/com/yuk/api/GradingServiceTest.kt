package com.yuk.api

import com.yuk.api.grading.GradingService
import com.yuk.domain.grading.TeacherId
import com.yuk.domain.test.Grade
import com.yuk.domain.test.SubmitAnswerId
import com.yuk.domain.test.SubmitTestId
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class GradingServiceTest {
    @Autowired
    private lateinit var gradingService: GradingService

    @Test
    fun gradingAnswer() {
        gradingService.gradingTest(
            TeacherId(1),
            SubmitTestId(1),
            SubmitAnswerId(1),
            Grade.A
        )
    }
}
