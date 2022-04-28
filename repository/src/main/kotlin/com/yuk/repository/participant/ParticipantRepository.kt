package com.yuk.repository.participant

import com.yuk.domain.participant.Participant
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
internal class ParticipantRepository(
    private val participantJPARepository: ParticipantJPARepository
) {}

internal interface ParticipantJPARepository: JpaRepository<Participant, Long> {
}