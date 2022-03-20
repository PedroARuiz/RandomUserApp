package org.edrodev.randomuserapp.data.remote.user.model


import kotlinx.serialization.Serializable
import org.edrodev.randomuserapp.domain.user.model.Picture

@Serializable
data class NetworkPicture(
    val large: String,
    val medium: String,
    val thumbnail: String
)

fun NetworkPicture.toPicture() = Picture(
    large = large,
    medium = medium,
    thumbnail = thumbnail,
)