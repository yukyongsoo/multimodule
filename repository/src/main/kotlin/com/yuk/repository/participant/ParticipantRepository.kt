package com.yuk.repository.participant

import com.yuk.domain.participant.Participant
import com.yuk.domain.participant.ParticipantId
import com.yuk.domain.participant.Participants
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
internal class ParticipantRepository(
    private val participantJPARepository: ParticipantJPARepository
) : Participants {
    override fun findParticipant(participantId: ParticipantId): Participant? {
        return participantJPARepository.findByIdOrNull(participantId.id)
    }
}

internal interface ParticipantJPARepository : JpaRepository<Participant, Long>
