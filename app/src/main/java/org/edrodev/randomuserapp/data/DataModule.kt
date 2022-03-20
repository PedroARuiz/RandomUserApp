package org.edrodev.randomuserapp.data

import org.edrodev.randomuserapp.data.repository.user.UserRepositoryImpl
import org.edrodev.randomuserapp.domain.user.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single<UserRepository> {
        UserRepositoryImpl(
            userLocalDataSource = get(),
            userRemoteDataSource = get(),
        )
    }
}