package org.edrodev.randomuserapp.data.local.user.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import org.edrodev.randomuserapp.data.local.user.model.EntityDeleteUser

@Dao
interface DeleteUserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: EntityDeleteUser)
}
