package com.yuk.repository.book

import com.yuk.domain.book.Book
import com.yuk.domain.book.BookId
import com.yuk.domain.book.Chapter
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.DiscriminatorColumn
import javax.persistence.DiscriminatorValue
import javax.persistence.Embeddable
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.OneToMany

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", columnDefinition = "TINYINT")
abstract class BookEntity(
    @EmbeddedId override val id: BookEntityId
) : Book(id) {

    @OneToMany(mappedBy = "bookEntity")
    override val chapters = mutableListOf<Chapter>()

    @Column
    override var beta: Boolean = true
}

@Embeddable
class BookEntityId : BookId(), Serializable {
    @Column
    override var id: Long = 0

    companion object {
        private const val serialVersionUID = 8138030663676459546L
    }
}

@DiscriminatorValue("0")
class DeadTreeBookEntity(bookId: BookId) : BookEntity(bookId)

@DiscriminatorValue("1")
class EBookEntity(bookId: BookId) : BookEntity(bookId)
