package com.yuk.domain.auction

import com.yuk.domain.money.Money
import com.yuk.domain.participant.Participant
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Bid(
    @Embedded
    val money: Money,
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    val participant: Participant
) {
    @Id
    val id = 0L

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    var auction = Auction()
}
