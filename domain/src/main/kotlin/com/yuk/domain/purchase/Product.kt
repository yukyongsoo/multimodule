package com.yuk.domain.purchase

import com.yuk.domain.book.Book
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class Product(
    @OneToOne(optional = false)
    open val book: Book
) {
    @delegate:Transient
    val productId by lazy {
        ProductId(id)
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}

class ProductId(
    val id: Long
)
