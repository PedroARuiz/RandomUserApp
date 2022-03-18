package org.edrodev.randomuserapp.data.remote.user.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkUser(
    val email: String,
    val gender: String,
    val location: NetworkLocation,
    val name: NetworkName,
    val phone: String,
    val picture: NetworkPicture,
    val registered: NetworkRegistered
)