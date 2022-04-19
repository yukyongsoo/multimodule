package com.yuk.domain.report

import com.yuk.domain.grading.Teacher
import com.yuk.domain.test.Location
import com.yuk.domain.test.Student
import com.yuk.domain.test.SubmitTest
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Report(
    @ManyToOne(optional = false)
    val school: Location,
    @ManyToOne(optional = false)
    val student: Student,
    @ManyToOne(optional = false)
    val teacher: Teacher,
    @ManyToOne(optional = false)
    val submitTest: SubmitTest
) {
    val reportId
        get() = ReportId(id)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id = 0L
}

class ReportId(
    val id: Long
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ReportId

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
