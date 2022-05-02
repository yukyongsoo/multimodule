package com.yuk.domain.auction

interface Auctions {
    fun findById(auctionId: AuctionId): Auction?
}
