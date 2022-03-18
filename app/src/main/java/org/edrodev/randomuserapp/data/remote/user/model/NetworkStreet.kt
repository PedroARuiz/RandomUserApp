package org.edrodev.randomuserapp.data.remote.user.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkStreet(
    val name: String,
    val number: Int
)