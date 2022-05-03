package com.yuk.api.auction

import com.yuk.api.participant.ParticipantService
import com.yuk.domain.auction.AuctionId
import com.yuk.domain.auction.Auctions
import com.yuk.domain.auction.Bid
import com.yuk.domain.money.Money
import com.yuk.domain.participant.ParticipantId
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AuctionService(
    private val auctions: Auctions,
    private val auctionQueue: AuctionQueue,
    private val participantService: ParticipantService
) {
    fun start(auctionId: AuctionId) {
        auctionQueue.start(auctionId)
    }

    fun bid(auctionId: AuctionId, participantId: ParticipantId, money: Money) {
        val participant = participantService.getParticipants(participantId)

        runBlocking {
            while (!auctionQueue.empty(auctionId)) {
                delay(1000)
            }
        }

        val bid = Bid(money, participant)
        auctionQueue.add(bid)

        val auction = auctions.findById(auctionId)
            ?: throw IllegalArgumentException("Auction not found")
        auction.addBid(bid)

        auctionQueue.remove(auctionId)
    }


}
