package org.edrodev.randomuserapp.data.local.user.model

import org.edrodev.randomuserapp.domain.user.model.Street

data class EntityStreet(
    val name: String,
    val number: Int,
)

fun Street.toEntityStreet() = EntityStreet(
    name = name,
    number = number,
)

fun EntityStreet.toStreet() = Street(
    name = name,
    number = number,
)
