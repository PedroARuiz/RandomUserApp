package org.edrodev.randomuserapp.domain.user.di

import org.edrodev.randomuserapp.domain.user.useCase.DeleteUserUseCase
import org.edrodev.randomuserapp.domain.user.useCase.FetchUsersUseCase
import org.edrodev.randomuserapp.domain.user.useCase.FindUserUseCase
import org.edrodev.randomuserapp.domain.user.useCase.FindUsersUseCase
import org.koin.dsl.module

val userModule = module {
    single {
        FetchUsersUseCase(
            userRepository = get(),
        )
    }

    single {
        FindUsersUseCase(
            userRepository = get(),
        )
    }

    single {
        DeleteUserUseCase(
            userRepository = get(),
        )
    }

    single {
        FindUserUseCase(
            userRepository = get(),
        )
    }
}