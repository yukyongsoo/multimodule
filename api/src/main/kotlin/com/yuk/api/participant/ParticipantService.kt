package com.yuk.api.participant

import com.yuk.domain.participant.Participant
import com.yuk.domain.participant.ParticipantId
import com.yuk.domain.participant.Participants
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ParticipantService(
    private val participants: Participants
) {
    fun getParticipants(participantId: ParticipantId): Participant {
        val participant = participants.findParticipant(participantId)
            ?: throw IllegalArgumentException("Participant not found")

        return participant
    }
}
