package org.edrodev.randomuserapp.domain.user.useCase

import kotlinx.coroutines.flow.Flow
import org.edrodev.randomuserapp.domain.user.model.User
import org.edrodev.randomuserapp.domain.user.repository.UserRepository

class FindUserUseCase(
    private val userRepository: UserRepository,
) {
    operator fun invoke(userEmail: String): Flow<User?> = userRepository.findUser(userEmail)
}