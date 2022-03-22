package org.edrodev.randomuserapp.data.local.user.dataSource

import arrow.core.Either
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.edrodev.randomuserapp.data.local.user.dao.DeleteUserDao
import org.edrodev.randomuserapp.data.local.user.dao.UserDao
import org.edrodev.randomuserapp.data.local.user.model.EntityUser
import org.edrodev.randomuserapp.data.local.user.model.toEntityDeleteUser
import org.edrodev.randomuserapp.data.local.user.model.toEntityUser
import org.edrodev.randomuserapp.data.local.user.model.toUser
import org.edrodev.randomuserapp.domain.user.model.User

class UserLocalDataSourceImpl(
    private val userDao: UserDao,
    private val deleteUserDao: DeleteUserDao,
) : UserLocalDataSource {
    override suspend fun saveUsers(users: List<User>): Either<Throwable, List<User>> = Either.catch {
        users
            .map(User::toEntityUser)
            .also { userDao.insert(it) }
    }.map { it.map(EntityUser::toUser) }

    override fun findUsers(): Flow<List<User>> = userDao
        .findUsers()
        .map{ it.map(EntityUser::toUser) }

    override suspend fun deleteUser(user: User) = deleteUserDao.insert(user.toEntityDeleteUser())
}