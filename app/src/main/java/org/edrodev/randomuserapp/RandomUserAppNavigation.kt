package org.edrodev.randomuserapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.edrodev.randomuserapp.userDetail.UserDetailScreen
import org.edrodev.randomuserapp.userList.UserListScreen

@Composable
fun RandomUserAppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "users") {

        composable("users") {
            UserListScreen(
                onUserClicked = { TODO("navigate to user detail") }
            )
        }

        composable("users/{userId}") {
            UserDetailScreen()
        }
    }

}