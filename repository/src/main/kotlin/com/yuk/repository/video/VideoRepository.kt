package com.yuk.repository.video

import com.yuk.domain.auction.AuctionId
import com.yuk.domain.video.Video
import com.yuk.domain.video.Videos
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
internal class VideoRepository(
    private val videoJPARepository: VideoJPARepository
) : Videos {
    override fun save(video: Video) {
        videoJPARepository.save(video)
    }

    override fun findById(auctionId: AuctionId): Video? {
        return videoJPARepository.findByIdOrNull(auctionId.id)
    }
}

internal interface VideoJPARepository : JpaRepository<Video, Long>
