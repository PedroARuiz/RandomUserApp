package org.edrodev.randomuserapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.edrodev.randomuserapp.data.local.converters.DateConverter
import org.edrodev.randomuserapp.data.local.user.dao.DeleteUserDao
import org.edrodev.randomuserapp.data.local.user.dao.UserDao
import org.edrodev.randomuserapp.data.local.user.model.EntityDeleteUser
import org.edrodev.randomuserapp.data.local.user.model.EntityUser

@Database(entities = [EntityUser::class, EntityDeleteUser::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class RandomUsersDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun deleteUserDao(): DeleteUserDao
}