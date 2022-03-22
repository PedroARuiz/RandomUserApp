package org.edrodev.randomuserapp.domain.user.repository

import arrow.core.Either
import kotlinx.coroutines.flow.Flow
import org.edrodev.randomuserapp.domain.user.model.User

interface UserRepository {

    suspend fun fetchUsers(count: Int): Either<Throwable, List<User>>

    fun findUsers(): Flow<List<User>>

}