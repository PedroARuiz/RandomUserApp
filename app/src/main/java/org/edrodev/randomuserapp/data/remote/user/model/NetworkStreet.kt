package org.edrodev.randomuserapp.data.remote.user.model

import kotlinx.serialization.Serializable
import org.edrodev.randomuserapp.domain.user.model.Street

@Serializable
data class NetworkStreet(
    val name: String,
    val number: Int
)

fun NetworkStreet.toStreet() = Street(
    name = name,
    number = number,
)