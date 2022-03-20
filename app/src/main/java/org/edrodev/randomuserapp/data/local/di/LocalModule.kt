package org.edrodev.randomuserapp.data.local.di

import androidx.room.Room
import org.edrodev.randomuserapp.data.local.RandomUsersDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            RandomUsersDataBase::class.java,
            "random-users-app",
        ).build()
    }
}