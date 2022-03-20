package org.edrodev.randomuserapp.data.local.user.dataSource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.edrodev.randomuserapp.data.local.user.dao.UserDao
import org.edrodev.randomuserapp.data.local.user.model.EntityUser
import org.edrodev.randomuserapp.data.local.user.model.toEntityUser
import org.edrodev.randomuserapp.data.local.user.model.toUser
import org.edrodev.randomuserapp.data.remote.user.service.UserService
import org.edrodev.randomuserapp.data.remote.user.service.UsersResponse
import org.edrodev.randomuserapp.domain.user.model.User

class UserLocalDataSourceImpl(
    private val userDao: UserDao,
) : UserLocalDataSource {
    override suspend fun saveUsers(users: List<User>) = users
        .map(User::toEntityUser)
        .forEach { userDao.insert(it) }

    override fun findUsers(): Flow<User> = userDao
        .findUsers()
        .map(EntityUser::toUser)
}