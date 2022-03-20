package org.edrodev.randomuserapp.domain.user.useCase

import org.edrodev.randomuserapp.domain.user.model.User
import org.edrodev.randomuserapp.domain.user.repository.UserRepository

class FetchUsersUseCase(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(): List<User> = userRepository.fetchUsers()
}