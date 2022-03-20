package org.edrodev.randomuserapp.data.remote.user.model


import kotlinx.serialization.Serializable
import org.edrodev.randomuserapp.domain.user.model.Name

@Serializable
data class NetworkName(
    val first: String,
    val last: String,
    val title: String
)

fun NetworkName.toName() = Name(
    first = first,
    last = last,
    title = title,
)