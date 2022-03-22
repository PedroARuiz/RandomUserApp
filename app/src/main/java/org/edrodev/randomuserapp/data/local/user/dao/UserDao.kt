package org.edrodev.randomuserapp.data.local.user.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import org.edrodev.randomuserapp.data.local.user.model.EntityUser

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(users: List<EntityUser>)

    @Query("""
        SELECT *
        FROM EntityUser
        WHERE email NOT IN(
            SELECT *
            FROM EntityDeleteUser
        ) AND (
        email LIKE '%' || :query || '%'
        OR first LIKE '%' || :query || '%'
        OR last LIKE '%' || :query || '%'
        )
    """)
    fun findUsers(query: String): Flow<List<EntityUser>>

}