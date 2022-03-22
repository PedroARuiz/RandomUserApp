package org.edrodev.randomuserapp.domain.user.useCase

import arrow.core.Either
import org.edrodev.randomuserapp.domain.user.model.User
import org.edrodev.randomuserapp.domain.user.repository.UserRepository

private const val DEFAULT_COUNT_USER_FETCH = 10

class FetchUsersUseCase(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(): Either<Throwable, List<User>> =
        userRepository.fetchUsers(DEFAULT_COUNT_USER_FETCH)
}