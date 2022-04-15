package com.yuk.domain.purchase

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class PurchasedProduct(
    @ManyToOne(optional = false)
    val product: Product,
    @ManyToOne(optional = false)
    val customer: Customer
) {
    @delegate:Transient
    val purchaseId by lazy {
        PurchaseId(id)
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}

class PurchaseId(
    val id: Long
)
