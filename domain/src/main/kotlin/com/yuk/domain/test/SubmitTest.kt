package com.yuk.domain.test

import com.yuk.domain.testpaper.Test
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Index
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "submit_test", indexes = [Index(columnList = "test_id, student_id", unique = true)])
class SubmitTest(
    @ManyToOne(optional = false) val test: Test,
    @ManyToOne(optional = false) val student: Student,
    @ManyToOne(optional = false) val location: Location
) {
    val submitAnswerId
        get() = SubmitAnswerId(id)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id = 0L

    @OneToMany(mappedBy = "submitTest")
    val submitAnswers = mutableListOf<SubmitAnswer>()
}

class SubmitTestId(
    val id: Long
)
