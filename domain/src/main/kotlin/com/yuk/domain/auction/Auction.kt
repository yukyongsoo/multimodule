package com.yuk.domain.auction

import com.yuk.domain.money.Money
import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

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

    @OneToMany(mappedBy = "auction")
    val bids = mutableListOf<Bid>()

    @Transient
    val participants = mutableListOf<Bid>()
}

data class AuctionId(val id: Long)