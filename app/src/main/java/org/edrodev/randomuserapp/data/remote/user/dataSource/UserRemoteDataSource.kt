package org.edrodev.randomuserapp.data.remote.user.dataSource

import org.edrodev.randomuserapp.domain.user.model.User

interface UserRemoteDataSource {

    suspend fun getRandomUsers(): List<User>
}