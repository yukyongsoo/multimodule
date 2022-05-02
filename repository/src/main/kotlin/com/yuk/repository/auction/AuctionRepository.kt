package com.yuk.repository.auction

import com.yuk.domain.auction.Auction
import com.yuk.domain.auction.AuctionId
import com.yuk.domain.auction.Auctions
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
internal class AuctionRepository(
    private val auctionJPARepository: AuctionJPARepository
) : Auctions {
    override fun findById(auctionId: AuctionId): Auction? {
        return auctionJPARepository.findByIdOrNull(auctionId.id)
    }
}

internal interface AuctionJPARepository : JpaRepository<Auction, Long>
