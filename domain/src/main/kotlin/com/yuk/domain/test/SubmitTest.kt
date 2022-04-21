package com.yuk.domain.test

import com.yuk.domain.testpaper.Test
import javax.persistence.CascadeType
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

    @OneToMany(mappedBy = "submitTest", cascade = [CascadeType.ALL])
    val submitAnswers = mutableListOf<SubmitAnswer>()

    fun findSubmitAnswer(submitAnswerId: SubmitAnswerId): SubmitAnswer? {
        return submitAnswers.find { it.submitAnswerId == submitAnswerId }
    }

    fun addAnswers(submitAnswers: Collection<SubmitAnswer>) {
        this.submitAnswers.addAll(submitAnswers)
    }
}

class SubmitTestId(
    val id: Long
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SubmitTestId

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
