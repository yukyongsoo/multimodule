package com.yuk.api.auction

import com.yuk.domain.auction.AuctionId
import com.yuk.domain.auction.Auctions
import com.yuk.domain.money.Money
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AuctionService(
    private val auctions: Auctions
) {
    fun bid(auctionId: AuctionId, money: Money) {

    }
}
