package com.yuk.api.video

import com.yuk.domain.auction.AuctionId
import com.yuk.domain.video.Video
import com.yuk.domain.video.Videos
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class VideoService(
    private val videos: Videos
) {
    fun recoding(auctionId: AuctionId) {
        val video = Video(auctionId)
        video.recoding()

        videos.save(video)
    }

    fun stopRecoding(auctionId: AuctionId) {
        val video = videos.findById(auctionId)
            ?: throw IllegalArgumentException("입찰 종료된 영상이 없습니다.")

        video.stopRecoding()
    }
}
