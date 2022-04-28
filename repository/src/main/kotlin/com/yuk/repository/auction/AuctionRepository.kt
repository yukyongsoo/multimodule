package com.yuk.repository.auction

import com.yuk.domain.auction.Auction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
internal class AuctionRepository(
    private val auctionJPARepository: AuctionJPARepository
) {

}

internal interface AuctionJPARepository: JpaRepository<Auction, Long> {
}