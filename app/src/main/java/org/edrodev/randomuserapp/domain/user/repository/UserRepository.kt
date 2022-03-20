package org.edrodev.randomuserapp.domain.user.repository

import kotlinx.coroutines.flow.Flow
import org.edrodev.randomuserapp.domain.user.model.User

interface UserRepository {

    suspend fun fetchUsers(): List<User>

    fun findUsers(): Flow<List<User>>

}