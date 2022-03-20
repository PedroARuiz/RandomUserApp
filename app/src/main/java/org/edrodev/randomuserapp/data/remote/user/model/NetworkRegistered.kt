package org.edrodev.randomuserapp.data.remote.user.model


import java.util.*
import kotlinx.serialization.Serializable
import org.edrodev.randomuserapp.data.remote.serializer.DateSerializer

@Serializable
data class NetworkRegistered(
    @Serializable(DateSerializer::class)
    val date: Date,
)