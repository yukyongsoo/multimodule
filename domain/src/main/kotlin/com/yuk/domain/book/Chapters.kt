package com.yuk.domain.book

interface Chapters {
    fun create(chapter: Chapter)
    fun findById(chapterId: ChapterId): Chapter?
}
