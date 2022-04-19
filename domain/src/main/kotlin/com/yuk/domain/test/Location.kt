package com.yuk.domain.test

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Index
import javax.persistence.Table

@Entity
@Table(name = "location", indexes = [Index(unique = true, columnList = "state, address")])
class Location(
    @Column(nullable = false)
    val state: String,
    @Column(nullable = false)
    val address: String
) {
    companion object {
        val EMPTY = Location("", "")
    }

    val locationId
        get() = LocationId(id)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id = 0L
}

class LocationId(
    val id: Long
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LocationId

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
