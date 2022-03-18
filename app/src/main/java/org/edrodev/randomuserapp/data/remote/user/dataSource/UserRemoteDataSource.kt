package org.edrodev.randomuserapp.data.remote.user.dataSource

import org.edrodev.randomuserapp.data.remote.user.service.UsersResponse

interface UserRemoteDataSource {

    suspend fun getRandomUsers(): UsersResponse
}