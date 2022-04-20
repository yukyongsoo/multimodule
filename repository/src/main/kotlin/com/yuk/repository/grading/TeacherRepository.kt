package com.yuk.repository.grading

import com.yuk.domain.grading.Teacher
import com.yuk.domain.grading.TeacherId
import com.yuk.domain.grading.Teachers
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TeacherRepository(
    private val teacherJpaRepository: TeacherJpaRepository
) : Teachers {
    override fun findById(teacherId: TeacherId): Teacher? {
        return teacherJpaRepository.findByIdOrNull(teacherId.id)
    }

    override fun exist(teacherId: TeacherId): Boolean {
        return teacherJpaRepository.existsById(teacherId.id)
    }
}

interface TeacherJpaRepository : JpaRepository<Teacher, Long>
