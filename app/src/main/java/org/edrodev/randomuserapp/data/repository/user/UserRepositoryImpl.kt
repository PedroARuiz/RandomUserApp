package org.edrodev.randomuserapp.data.repository.user

import kotlinx.coroutines.flow.Flow
import org.edrodev.randomuserapp.data.local.user.dataSource.UserLocalDataSource
import org.edrodev.randomuserapp.data.remote.user.dataSource.UserRemoteDataSource
import org.edrodev.randomuserapp.domain.user.model.User
import org.edrodev.randomuserapp.domain.user.repository.UserRepository

class UserRepositoryImpl(
    private val userLocalDataSource: UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource,
) : UserRepository {
    override suspend fun fetchUsers(count: Int): List<User> = userRemoteDataSource.getRandomUsers(count).also {
        userLocalDataSource.saveUsers(it)
    }

    override fun findUsers(): Flow<List<User>> = userLocalDataSource.findUsers()
}