package com.yuk.domain.grading

interface Teachers {
    fun exist(teacherId: TeacherId): Boolean
    fun findById(teacherId: TeacherId): Teacher?
}
