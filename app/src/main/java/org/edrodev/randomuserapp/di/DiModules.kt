package org.edrodev.randomuserapp.di

import org.edrodev.randomuserapp.data.dataModule
import org.edrodev.randomuserapp.data.local.di.localModule
import org.edrodev.randomuserapp.data.local.user.di.userLocalModule
import org.edrodev.randomuserapp.data.remote.di.remoteModule
import org.edrodev.randomuserapp.data.remote.user.di.userRemoteModule
import org.edrodev.randomuserapp.domain.user.di.userModule

val diModules = listOf(
    userModule,
    dataModule,
    remoteModule,
    localModule,
    userRemoteModule,
    userLocalModule,
)