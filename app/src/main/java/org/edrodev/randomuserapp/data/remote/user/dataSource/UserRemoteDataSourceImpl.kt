package org.edrodev.randomuserapp.data.remote.user.dataSource

import org.edrodev.randomuserapp.data.remote.user.service.UserService
import org.edrodev.randomuserapp.data.remote.user.service.UsersResponse

class UserRemoteDataSourceImpl(
    private val userService: UserService,
) : UserRemoteDataSource {

    override suspend fun getRandomUsers() : UsersResponse =
        userService.getRandomUsers()
}