package org.edrodev.randomuserapp.domain.user.model

import java.util.*

data class User(
    val email: String,
    val gender: Gender,
    val location: Location,
    val name: Name,
    val phone: String,
    val picture: Picture,
    val registeredDate: Date,
)
