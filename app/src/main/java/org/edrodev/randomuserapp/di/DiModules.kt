package org.edrodev.randomuserapp.di

import org.edrodev.randomuserapp.data.remote.di.remoteModule
import org.edrodev.randomuserapp.data.remote.user.di.userRemoteModule
import org.edrodev.randomuserapp.domain.user.di.userModule

val diModules = listOf(
    userModule,
    remoteModule,
    userRemoteModule,
)