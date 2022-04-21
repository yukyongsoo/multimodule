package com.yuk.repository.test

import com.yuk.domain.test.Location
import com.yuk.domain.test.LocationId
import com.yuk.domain.test.Locations
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
internal class LocationRepository(
    private val locationJpaRepository: LocationJpaRepository
) : Locations {
    override fun findById(locationId: LocationId): Location? {
        return locationJpaRepository.findByIdOrNull(locationId.id)
    }
}

internal interface LocationJpaRepository : JpaRepository<Location, Long>
