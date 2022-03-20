package org.edrodev.randomuserapp.data.remote.user.model

import kotlinx.serialization.Serializable
import org.edrodev.randomuserapp.domain.user.model.Location

@Serializable
data class NetworkLocation(
    val city: String,
    val state: String,
    val street: NetworkStreet,
)

fun NetworkLocation.toLocation() = Location(
    city = city,
    state = state,
    street = street.toStreet(),
)