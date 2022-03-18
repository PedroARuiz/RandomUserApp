package org.edrodev.randomuserapp.di

import org.edrodev.randomuserapp.data.remote.di.remoteModule
import org.edrodev.randomuserapp.data.remote.user.di.userRemoteModule

val diModules = listOf(
    remoteModule,
    userRemoteModule,
)