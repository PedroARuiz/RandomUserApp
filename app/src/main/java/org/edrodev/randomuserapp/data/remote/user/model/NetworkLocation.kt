package org.edrodev.randomuserapp.data.remote.user.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkLocation(
    val city: String,
    val state: String,
    val street: NetworkStreet,
)