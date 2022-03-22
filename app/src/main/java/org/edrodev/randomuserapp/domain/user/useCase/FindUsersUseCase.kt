package org.edrodev.randomuserapp.domain.user.useCase

import kotlinx.coroutines.flow.Flow
import org.edrodev.randomuserapp.domain.user.model.User
import org.edrodev.randomuserapp.domain.user.repository.UserRepository

class FindUsersUseCase(
    private val userRepository: UserRepository,
) {
    operator fun invoke(query: String): Flow<List<User>> = userRepository.findUsers(query)
}