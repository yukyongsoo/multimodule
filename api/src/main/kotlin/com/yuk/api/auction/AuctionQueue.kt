package com.yuk.api.auction

import com.yuk.domain.auction.AuctionId
import com.yuk.domain.auction.Bid
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuctionQueue {
    private val queue = mutableMapOf<AuctionId, MutableList<Bid>>()

    fun start(auctionId: AuctionId) {
        queue[auctionId] = LinkedList()
    }

    fun add(bid: Bid) {

    }

    fun poll(): Bid? {
        TODO()
    }
}