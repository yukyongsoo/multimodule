package com.yuk.domain.participant

interface Participants {
    fun findParticipant(participantId: ParticipantId): Participant?
}
