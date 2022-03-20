package org.edrodev.randomuserapp.data.local.user.model

import org.edrodev.randomuserapp.domain.user.model.Picture

data class EntityPicture(
    val large: String,
    val medium: String,
    val thumbnail: String
)

fun Picture.toEntityPicture() = EntityPicture(
    large = large,
    medium = medium,
    thumbnail = thumbnail,
)

fun EntityPicture.toPicture() = Picture(
    large = large,
    medium = medium,
    thumbnail = thumbnail,
)