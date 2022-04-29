package com.yuk.api.participant

import com.yuk.domain.participant.Participants
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ParticipantService(
    private val participants: Participants
)
