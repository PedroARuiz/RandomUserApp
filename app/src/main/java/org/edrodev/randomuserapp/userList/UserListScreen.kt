package org.edrodev.randomuserapp.userList

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import org.edrodev.randomuserapp.data.remote.user.dataSource.UserRemoteDataSource
import org.koin.androidx.compose.get

@Composable
fun UserListScreen() {
    Text(text = "Welcome to RandomUserApp!")

    val dataSource: UserRemoteDataSource = get()

    LaunchedEffect(key1 = null) {
        println("RandomUsersResponse: ${dataSource.getRandomUsers()}")
    }
}