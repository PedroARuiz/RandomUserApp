package org.edrodev.randomuserapp.userList

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.edrodev.randomuserapp.domain.user.repository.UserRepository
import org.koin.androidx.compose.get

@Composable
fun UserListScreen() {
    Text(text = "Welcome to RandomUserApp!")

    val repo: UserRepository = get()

    LaunchedEffect(key1 = null) {
        repo.fetchUsers(5)
    }

    LaunchedEffect(key1 = null) {
        repo.findUsers()
            .onEach { println("RandomUsersResponse: $it") }
            .launchIn(this)
    }
}