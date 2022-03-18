package org.edrodev.randomuserapp.data.remote.user.service

import kotlinx.serialization.Serializable
import org.edrodev.randomuserapp.data.remote.user.model.NetworkUser

@Serializable
data class UsersResponse(
    val results: List<NetworkUser>,
)
