package com.yuk.domain.video

import com.yuk.domain.auction.Auction
import com.yuk.domain.auction.AuctionId
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.MapsId
import javax.persistence.OneToOne

@Entity
class Video(
    @Transient
    val auctionId: AuctionId
) {
    @Id
    private var id = auctionId.id

    @MapsId
    @OneToOne(mappedBy = "video", fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    val auction: Auction = Auction()

    @Embedded
    var url = URL.EMPTY
        protected set

    fun recoding() {
    }

    fun stopRecoding() {
    }
}
