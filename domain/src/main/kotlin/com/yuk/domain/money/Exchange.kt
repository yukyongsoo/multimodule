package com.yuk.domain.money

import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Exchange(
    @Embedded val from: Currency,
    @Embedded val to: Currency,
    @Column val rate: Double
) {
    @Id
    private val id = 0
}
