package com.yuk.domain.testpaper

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Test {
    val testId
        get() = TestId(id)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id = 0L

    @OneToMany(mappedBy = "test", cascade = [CascadeType.ALL])
    val problemList = mutableListOf<Problem>()

    fun findProblems(problemIds: Collection<ProblemId>): List<Problem> {
        val problems = problemList.filter { problemIds.contains(it.problemId) }

        if (problems.size != problemIds.size) {
            throw IllegalArgumentException("problemIds is not exist")
        }

        return problems
    }
}

class TestId(
    val id: Long
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TestId

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
