package com.yuk.repository.test

import com.yuk.domain.test.Student
import com.yuk.domain.test.StudentId
import com.yuk.domain.test.Students
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
internal class StudentRepository(
    private val studentJpaRepository: StudentJpaRepository
) : Students {
    override fun findById(studentId: StudentId): Student? {
        return studentJpaRepository.findByIdOrNull(studentId.id)
    }
}

internal interface StudentJpaRepository : JpaRepository<Student, Long>
