package org.edrodev.randomuserapp.data.local.user.di

import org.edrodev.randomuserapp.data.local.RandomUsersDataBase
import org.edrodev.randomuserapp.data.local.user.dataSource.UserLocalDataSource
import org.edrodev.randomuserapp.data.local.user.dataSource.UserLocalDataSourceImpl
import org.koin.dsl.module

val userLocalModule = module {
    single { get<RandomUsersDataBase>().userDao() }

    single<UserLocalDataSource> {
        UserLocalDataSourceImpl(
            userDao = get(),
        )
    }
}