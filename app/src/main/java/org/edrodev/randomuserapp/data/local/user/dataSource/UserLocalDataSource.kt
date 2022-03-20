package org.edrodev.randomuserapp.data.local.user.dataSource

import kotlinx.coroutines.flow.Flow
import org.edrodev.randomuserapp.domain.user.model.User

interface UserLocalDataSource {

    suspend fun saveUsers(users: List<User>)
    fun findUsers(): Flow<User>
}