package org.edrodev.randomuserapp.data.local.user.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.edrodev.randomuserapp.domain.user.model.User

@Entity
data class EntityDeleteUser(
    @PrimaryKey val email: String,
)

fun User.toEntityDeleteUser() = EntityDeleteUser(
    email = email,
)
