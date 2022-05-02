package com.yuk.domain.participant

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Participant {
    val participantId
        get() = ParticipantId(id)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long = 0

    @Column
    val totalRating: Double = 0.0

    @Column
    val totalRatingCount: Int = 0

    val rating: Double
        get() {
            return if (totalRatingCount == 0) 0.0
            else totalRating / totalRatingCount
        }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Participant

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }


}

data class ParticipantId(val id: Long)
