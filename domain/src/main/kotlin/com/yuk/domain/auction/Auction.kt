package com.yuk.domain.auction

import com.yuk.domain.money.Money
import com.yuk.domain.participant.Participant
import com.yuk.domain.video.Video
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.PrimaryKeyJoinColumn

@Entity
class Auction {
    val auctionId
        get() = AuctionId(id)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id = 0L

    @Embedded
    val category = Category.EMPTY

    @Column
    val name = ""

    @Column
    var maxPrice = Money.ZERO
        protected set

    @OneToMany(mappedBy = "auction", cascade = [CascadeType.ALL])
    val bids = mutableListOf<Bid>()

    @OneToOne(cascade = [CascadeType.ALL])
    @PrimaryKeyJoinColumn
    val video = Video(auctionId)

    @Transient
    private val participants = mutableSetOf<Participant>()

    fun addBid(bid: Bid) {
        if (maxPrice < bid.money) {
            maxPrice = bid.money
        }

        bids.add(bid)
        bid.auction = this
        participants.add(bid.participant)
    }
}

data class AuctionId(val id: Long)
