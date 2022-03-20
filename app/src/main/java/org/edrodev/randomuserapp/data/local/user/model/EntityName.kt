package org.edrodev.randomuserapp.data.local.user.model

import org.edrodev.randomuserapp.domain.user.model.Name

data class EntityName(
    val first: String,
    val last: String,
    val title: String,
)

fun Name.toEntityName() = EntityName(
    first = first,
    last = last,
    title = title,
)

fun EntityName.toName() = Name(
    first = first,
    last = last,
    title = title,
)
