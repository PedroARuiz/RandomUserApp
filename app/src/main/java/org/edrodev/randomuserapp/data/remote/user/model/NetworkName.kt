package org.edrodev.randomuserapp.data.remote.user.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkName(
    @SerialName("first")
    val first: String,
    @SerialName("last")
    val last: String,
    @SerialName("title")
    val title: String
)