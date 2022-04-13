package com.yuk.repository.book

import com.yuk.domain.book.Book
import com.yuk.domain.book.BookId
import com.yuk.domain.book.Chapter
import com.yuk.domain.purchase.Product
import com.yuk.repository.purchase.ProductEntity
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.DiscriminatorColumn
import javax.persistence.DiscriminatorValue
import javax.persistence.Embeddable
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.MapsId
import javax.persistence.OneToMany
import javax.persistence.OneToOne

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", columnDefinition = "TINYINT")
abstract class BookEntity : Book() {
    @EmbeddedId
    override val id: BookEntityId = BookEntityId()

    @OneToMany(mappedBy = "bookEntity")
    override val chapters = mutableListOf<ChapterEntity>()

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "bookEntity")
    override var product: Product? = null

    @Column
    override var beta: Boolean = true
}

@Embeddable
class BookEntityId : BookId(), Serializable {
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override val id: Long = 0

    companion object {
        private const val serialVersionUID = 8138030663676459546L
    }
}

@DiscriminatorValue("0")
class DeadTreeBookEntity : BookEntity()

@DiscriminatorValue("1")
class EBookEntity : BookEntity()
