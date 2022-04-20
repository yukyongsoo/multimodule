package com.yuk.api.grading

import com.yuk.domain.grading.TeacherId
import com.yuk.domain.grading.Teachers
import com.yuk.domain.test.Grade
import com.yuk.domain.test.SubmitAnswerId
import com.yuk.domain.test.SubmitTestId
import com.yuk.domain.test.SubmitTests
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class GradingService(
    private val teachers: Teachers,
    private val submitTests: SubmitTests
) {
    fun gradingTest(
        teacherId: TeacherId,
        submitTestId: SubmitTestId,
        submitAnswerId: SubmitAnswerId,
        grade: Grade
    ) {
        if (teachers.exist(teacherId).not())
            throw IllegalArgumentException("teacher not exist")

        val submitTest = submitTests.findById(submitTestId)
            ?: throw IllegalArgumentException("submitted test not exist")

        val answer = submitTest.findSubmitAnswer(submitAnswerId)
            ?: throw IllegalArgumentException("submitted answer not exist")

        answer.grading(grade)
    }
}
