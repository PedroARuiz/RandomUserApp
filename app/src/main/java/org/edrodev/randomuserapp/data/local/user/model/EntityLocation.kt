package org.edrodev.randomuserapp.data.local.user.model

import androidx.room.Embedded
import org.edrodev.randomuserapp.domain.user.model.Location

data class EntityLocation(
    val city: String,
    val state: String,
    @Embedded
    val street: EntityStreet,
)

fun Location.toEntityLocation() = EntityLocation(
    city = city,
    state = state,
    street = street.toEntityStreet(),
)

fun EntityLocation.toLocation() = Location(
    city = city,
    state = state,
    street = street.toStreet(),
)