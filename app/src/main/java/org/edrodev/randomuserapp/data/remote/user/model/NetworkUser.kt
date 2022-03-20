package org.edrodev.randomuserapp.data.remote.user.model

import kotlinx.serialization.Serializable
import org.edrodev.randomuserapp.domain.user.model.Gender
import org.edrodev.randomuserapp.domain.user.model.User

@Serializable
data class NetworkUser(
    val email: String,
    val gender: String,
    val location: NetworkLocation,
    val name: NetworkName,
    val phone: String,
    val picture: NetworkPicture,
    val registered: NetworkRegistered,
)

fun NetworkUser.toUser() = User(
    email = email,
    gender = Gender.valueOf(gender),
    location = location.toLocation(),
    name = name.toName(),
    phone = phone,
    picture = picture.toPicture(),
    registeredDate = registered.date,
)