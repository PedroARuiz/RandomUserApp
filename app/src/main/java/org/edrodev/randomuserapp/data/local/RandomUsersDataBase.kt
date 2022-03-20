package org.edrodev.randomuserapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import org.edrodev.randomuserapp.data.local.user.dao.UserDao
import org.edrodev.randomuserapp.data.local.user.model.EntityUser

@Database(entities = [EntityUser::class], version = 1)
abstract class RandomUsersDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}