package org.edrodev.randomuserapp.data.remote.user.service

import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("api/")
    suspend fun getRandomUsers(
        @Query("results") count: Int = 1,
    ) : UsersResponse

}