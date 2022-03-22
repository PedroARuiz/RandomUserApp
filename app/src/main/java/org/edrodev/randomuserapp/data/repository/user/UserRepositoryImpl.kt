package org.edrodev.randomuserapp.data.repository.user

import arrow.core.Either
import arrow.core.left
import kotlinx.coroutines.flow.Flow
import org.edrodev.randomuserapp.data.local.user.dataSource.UserLocalDataSource
import org.edrodev.randomuserapp.data.remote.user.dataSource.UserRemoteDataSource
import org.edrodev.randomuserapp.domain.user.model.User
import org.edrodev.randomuserapp.domain.user.repository.UserRepository

class UserRepositoryImpl(
    private val userLocalDataSource: UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource,
) : UserRepository {
    override suspend fun fetchUsers(count: Int): Either<Throwable, List<User>> =
        userRemoteDataSource.getRandomUsers(count).fold(
            ifRight = {
                userLocalDataSource.saveUsers(it)
            },
            ifLeft = { it.left() }
        )

    override fun findUsers(query: String): Flow<List<User>> = userLocalDataSource.findUsers(query)
    override fun findUser(userEmail: String): Flow<User?> = userLocalDataSource.findUser(userEmail)

    override suspend fun deleteUser(user: User) = userLocalDataSource.deleteUser(user)
}