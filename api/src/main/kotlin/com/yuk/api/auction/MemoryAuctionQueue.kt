package com.yuk.api.auction

import com.yuk.domain.auction.AuctionId
import com.yuk.domain.auction.Bid
import org.springframework.stereotype.Service
import java.util.*

@Service
class MemoryAuctionQueue : AuctionQueue {
    val queue = mutableMapOf<AuctionId, MutableList<Bid>>()

    override fun start(auctionId: AuctionId) {
        queue[auctionId] = LinkedList()
    }

    override fun add(bid: Bid) {
        queue[bid.auction.auctionId]?.add(bid)
            ?: throw IllegalStateException("Auction ${bid.auction.auctionId} is not started")
    }

    override fun empty(auctionId: AuctionId): Boolean {
        return queue[auctionId]?.isEmpty()
            ?: throw IllegalStateException("Auction $auctionId is not started")
    }
}