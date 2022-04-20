package com.yuk.domain.test

import com.yuk.domain.testpaper.Problem
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Index
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "submit_answer", indexes = [Index(columnList = "submit_test_id, problem_id", unique = true)])
class SubmitAnswer(
    @ManyToOne(optional = false)
    val problem: Problem,
    @ManyToOne(optional = false)
    val submitTest: SubmitTest
) {
    val submitAnswerId
        get() = SubmitAnswerId(id)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long = 0

    @Column
    var grade = Grade.NONE
        protected set

    fun grading(grade: Grade) {
        if (this.grade != Grade.NONE) {
            throw IllegalArgumentException("grade already set")
        }

        this.grade = grade
    }
}

class SubmitAnswerId(
    val id: Long
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SubmitAnswerId

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
