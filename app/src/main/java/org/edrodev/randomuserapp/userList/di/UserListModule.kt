package org.edrodev.randomuserapp.userList.di

import org.edrodev.randomuserapp.userList.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userListModule = module {
    viewModel {
        UserListViewModel(
            findUsers = get(),
            fetchUsers = get(),
            deleteUser = get(),
        )
    }
}