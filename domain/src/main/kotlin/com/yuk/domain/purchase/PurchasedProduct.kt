package com.yuk.domain.purchase

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.ManyToOne

@Entity
class PurchasedProduct(
    @ManyToOne(optional = false)
    val product: Product,
    @ManyToOne(optional = false)
    val customer: Customer
) {
    @EmbeddedId
    val purchaseId = PurchaseId()
}

@Embeddable
class PurchaseId(
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
) : Serializable {
    companion object {
        private const val serialVersionUID = -1308697221440354742L
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PurchaseId

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
