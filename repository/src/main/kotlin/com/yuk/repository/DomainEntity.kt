package com.yuk.repository

import com.yuk.domain.Domain
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class DomainEntity: Domain() {
    @Id
    override var id: Long = 0
        protected set
}