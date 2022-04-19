package com.yuk.domain.grading

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Teacher {
    val teacherId
        get() = TeacherId(id)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id = 0L
}

class TeacherId(
    val id: Long
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TeacherId

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
