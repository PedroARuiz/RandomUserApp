package org.edrodev.randomuserapp.userDetail.di

import org.edrodev.randomuserapp.userDetail.UserDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userDetailModule = module {
    viewModel { (userEmail: String) ->
        UserDetailViewModel(
            userEmail = userEmail,
            findUser = get(),
        )
    }
}