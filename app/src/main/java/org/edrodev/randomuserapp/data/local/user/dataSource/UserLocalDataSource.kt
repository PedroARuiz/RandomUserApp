package org.edrodev.randomuserapp.data.local.user.dataSource

import arrow.core.Either
import kotlinx.coroutines.flow.Flow
import org.edrodev.randomuserapp.domain.user.model.User

interface UserLocalDataSource {

    suspend fun saveUsers(users: List<User>): Either<Throwable, List<User>>
    fun findUsers(query: String): Flow<List<User>>
    fun findUser(userEmail: String): Flow<User?>
    suspend fun deleteUser(user: User)
}