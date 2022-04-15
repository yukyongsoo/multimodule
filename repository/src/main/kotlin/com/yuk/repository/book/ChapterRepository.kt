package com.yuk.repository.book

import com.yuk.domain.book.Chapter
import com.yuk.domain.book.ChapterId
import com.yuk.domain.book.Chapters
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
internal class ChapterRepository(
    private val chapterJpaRepository: ChapterJpaRepository
) : Chapters {
    override fun create(chapter: Chapter) {
        chapterJpaRepository.save(chapter)
    }

    override fun findById(chapterId: ChapterId): Chapter? {
        return chapterJpaRepository.findByIdOrNull(chapterId.id)
    }
}

internal interface ChapterJpaRepository : JpaRepository<Chapter, Long>
