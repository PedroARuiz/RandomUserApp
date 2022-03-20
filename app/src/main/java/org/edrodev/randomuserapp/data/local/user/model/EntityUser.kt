package org.edrodev.randomuserapp.data.local.user.model

import androidx.room.Embedded
import androidx.room.Entity
import java.util.*
import org.edrodev.randomuserapp.domain.user.model.Gender
import org.edrodev.randomuserapp.domain.user.model.User

@Entity
data class EntityUser(
    val email: String,
    val gender: String,
    @Embedded
    val location: EntityLocation,
    @Embedded
    val name: EntityName,
    val phone: String,
    @Embedded
    val picture: EntityPicture,
    val registeredDate: Date,
)

fun User.toEntityUser() = EntityUser(
    email = email,
    gender = gender.name,
    location = location.toEntityLocation(),
    name = name.toEntityName(),
    phone = phone,
    picture = picture.toEntityPicture(),
    registeredDate = registeredDate,
)

fun EntityUser.toUser() = User(
    email = email,
    gender = Gender.valueOf(gender),
    location = location.toLocation(),
    name = name.toName(),
    phone = phone,
    picture = picture.toPicture(),
    registeredDate = registeredDate,
)
