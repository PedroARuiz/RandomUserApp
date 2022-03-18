package org.edrodev.randomuserapp.data.remote.user.di

import org.edrodev.randomuserapp.data.remote.user.dataSource.UserRemoteDataSource
import org.edrodev.randomuserapp.data.remote.user.dataSource.UserRemoteDataSourceImpl
import org.edrodev.randomuserapp.data.remote.user.service.UserService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val userRemoteModule = module {
    single<UserService> { get<Retrofit>().create() }
    single<UserRemoteDataSource> {
        UserRemoteDataSourceImpl(
            userService = get(),
        )
    }
}