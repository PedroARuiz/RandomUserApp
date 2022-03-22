package org.edrodev.randomuserapp.data.remote.user.dataSource

import arrow.core.Either
import org.edrodev.randomuserapp.domain.user.model.User

interface UserRemoteDataSource {

    suspend fun getRandomUsers(count: Int): Either<Throwable, List<User>>
}