package com.yuk.api.test

import com.yuk.domain.test.LocationId
import com.yuk.domain.test.StudentId
import com.yuk.domain.testpaper.ProblemId
import com.yuk.domain.testpaper.TestId

data class SubmitTestCommand(
    val testId: TestId,
    val studentId: StudentId,
    val locationId: LocationId,
    val answer: List<SubmitAnswerCommand>
)

data class SubmitAnswerCommand(
    val problemId: ProblemId,
    val answer: String
)
