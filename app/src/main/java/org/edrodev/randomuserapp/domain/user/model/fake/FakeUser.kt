package org.edrodev.randomuserapp.domain.user.model.fake

import java.util.*
import org.edrodev.randomuserapp.domain.user.model.Gender
import org.edrodev.randomuserapp.domain.user.model.Location
import org.edrodev.randomuserapp.domain.user.model.Name
import org.edrodev.randomuserapp.domain.user.model.Picture
import org.edrodev.randomuserapp.domain.user.model.Street
import org.edrodev.randomuserapp.domain.user.model.User

val fakeUser = User(
    email = "test@test.com",
    gender = Gender.female,
    location = Location(
        city = "City Test",
        state = "State test",
        street = Street(
            name = "Street name",
            number = 1,
        )
    ),
    name = Name(
        title = "Mrs",
        first = "Test",
        last = "Preview",
    ),
    phone = "123456789",
    picture = Picture(
        thumbnail = "",
        large = "",
        medium = "",
    ),
    registeredDate = Date(),
)