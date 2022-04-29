package com.yuk.api.auction

import com.yuk.domain.auction.Auctions
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AuctionService(
    private val auctions: Auctions
)
