package com.yuk.domain.test

interface SubmitTests {
    fun findById(submitTestId: SubmitTestId): SubmitTest?
    fun submit(submitTest: SubmitTest)
}
