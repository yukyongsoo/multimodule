package com.yuk.repository.book

import com.yuk.domain.book.Author
import com.yuk.domain.book.AuthorId
import com.yuk.domain.book.Book
import com.yuk.domain.book.BookId
import com.yuk.domain.book.Chapter
import com.yuk.domain.book.ChapterId
import com.yuk.domain.book.Content
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Embedded
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne

@Embeddable
class ChapterIdEntity: ChapterId(), Serializable {
    @Column
    override var id: Long = 0

    companion object {
        private const val serialVersionUID = -383114207597953779L
    }
}

@Embeddable
class ContentEntity(
    @Column
    override val content: String
): Content(content)

@Entity
class ChapterEntity(
    @Embedded
    override val content: Content,
    @Embedded
    override val author: Author
): Chapter(content, author) {
    @EmbeddedId
    override val id: ChapterIdEntity = ChapterIdEntity()

    @ManyToOne(fetch = FetchType.LAZY)
    override var book: Book?
}
