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
    suspend fun insert(user: EntityUser)

    @Query("""
        SELECT *
        FROM EntityUser
    """)
    fun findUsers(): Flow<EntityUser>

}