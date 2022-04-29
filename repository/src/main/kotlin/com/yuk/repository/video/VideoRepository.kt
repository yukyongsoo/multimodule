package com.yuk.repository.video

import com.yuk.domain.video.Video
import com.yuk.domain.video.Videos
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
internal class VideoRepository(
    private val videoJPARepository: VideoJPARepository
) : Videos

internal interface VideoJPARepository : JpaRepository<Video, Long>
