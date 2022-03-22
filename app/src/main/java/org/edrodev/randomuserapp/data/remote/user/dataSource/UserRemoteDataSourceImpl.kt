package org.edrodev.randomuserapp.data.remote.user.dataSource

import arrow.core.Either
import org.edrodev.randomuserapp.data.remote.user.model.NetworkUser
import org.edrodev.randomuserapp.data.remote.user.model.toUser
import org.edrodev.randomuserapp.data.remote.user.service.UserService
import org.edrodev.randomuserapp.domain.user.model.User

class UserRemoteDataSourceImpl(
    private val userService: UserService,
) : UserRemoteDataSource {

    override suspend fun getRandomUsers(count: Int) : Either<Throwable, List<User>> = Either.catch {
        userService.getRandomUsers(count).results.map(NetworkUser::toUser)
    }
}