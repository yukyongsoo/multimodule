package com.yuk.api.test

import com.yuk.domain.test.Locations
import com.yuk.domain.test.Students
import com.yuk.domain.test.SubmitAnswer
import com.yuk.domain.test.SubmitTest
import com.yuk.domain.test.SubmitTests
import com.yuk.domain.testpaper.Tests
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class TestService(
    private val submitTests: SubmitTests,
    private val tests: Tests,
    private val locations: Locations,
    private val students: Students
) {
    fun submit(submitTestCommand: SubmitTestCommand) {
        val location = locations.findById(submitTestCommand.locationId) ?: throw IllegalArgumentException("test not found")

        val student = students.findById(submitTestCommand.studentId) ?: throw IllegalArgumentException("student not found")

        val test = tests.findById(submitTestCommand.testId) ?: throw IllegalArgumentException("test not found")

        val submitTest = SubmitTest(
            test,
            student,
            location
        )

        val problems = test.findProblems(submitTestCommand.answer.map { it.problemId })
        val submitAnswers = problems.map { SubmitAnswer(it, submitTest) }
        submitTest.addAnswers(submitAnswers)

        submitTests.submit(submitTest)
    }
}
