package com.yuk.api.video

import com.yuk.domain.video.Videos
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class VideoService(
    private val videos: Videos
)
