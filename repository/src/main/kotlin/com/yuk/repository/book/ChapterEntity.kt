package com.yuk.repository.book

import com.yuk.domain.book.AuthorId
import com.yuk.domain.book.BookId
import com.yuk.domain.book.Chapter
import com.yuk.domain.book.ChapterId
import com.yuk.domain.book.Content
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Embedded
import javax.persistence.EmbeddedId

@Embeddable
class ChapterIdEntity: ChapterId(), Serializable {
    @Column
    override var id: Long = 0

    companion object {
        private const val serialVersionUID = -383114207597953779L
    }
}

@Embeddable
class AuthorIdColumn: AuthorId(), Serializable {
    @Column
    override var id: Long = 0

    companion object {
        private const val serialVersionUID = -383114207597953779L
    }
}

@Embeddable

class ChapterEntity(
    @Embedded
    override val authorId: AuthorIdColumn,
    @Embeddable
    override val bookId: BookId,
    @Embeddable
    override val content: Content
): Chapter(bookId, authorId, content) {
    @EmbeddedId
    override id: ChapterIdEntity


}



}