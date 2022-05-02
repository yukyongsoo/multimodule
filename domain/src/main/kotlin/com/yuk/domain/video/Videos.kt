package com.yuk.domain.video

import com.yuk.domain.auction.AuctionId

interface Videos {
    fun save(video: Video)
    fun findById(auctionId: AuctionId): Video?
}
