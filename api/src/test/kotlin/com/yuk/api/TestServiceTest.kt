package com.yuk.api

import com.yuk.api.test.SubmitAnswerCommand
import com.yuk.api.test.SubmitTestCommand
import com.yuk.api.test.TestService
import com.yuk.domain.test.LocationId
import com.yuk.domain.test.StudentId
import com.yuk.domain.testpaper.ProblemId
import com.yuk.domain.testpaper.TestId
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TestServiceTest {
    @Autowired
    private lateinit var testService: TestService

    @Test
    fun submitTest() {
        val locationId = LocationId(1)

        val studentId = StudentId(1)

        val testId = TestId(1)

        val submitTestCommand = SubmitTestCommand(
            testId, studentId, locationId,
            listOf(SubmitAnswerCommand(ProblemId(1), "1"))
        )

        testService.submit(submitTestCommand)
    }
}
