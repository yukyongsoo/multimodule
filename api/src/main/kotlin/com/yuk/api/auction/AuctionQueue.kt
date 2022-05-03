package com.yuk.api.auction

import com.yuk.domain.auction.AuctionId
import com.yuk.domain.auction.Bid

interface AuctionQueue {
    fun start(auctionId: AuctionId)
    fun add(bid: Bid)
    fun empty(auctionId: AuctionId): Boolean

    fun remove(auctionId: AuctionId)
}