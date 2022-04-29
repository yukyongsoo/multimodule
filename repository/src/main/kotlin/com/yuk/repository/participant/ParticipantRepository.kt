package com.yuk.repository.participant

import com.yuk.domain.participant.Participant
import com.yuk.domain.participant.Participants
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
internal class ParticipantRepository(
    private val participantJPARepository: ParticipantJPARepository
) : Participants

internal interface ParticipantJPARepository : JpaRepository<Participant, Long>
