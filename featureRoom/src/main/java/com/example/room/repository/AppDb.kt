package com.example.room.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(UserEntity::class), version = 1, exportSchema = false)
abstract class AppDb : RoomDatabase() {

    abstract fun userDao(): UserDao

    // Singleton object to get Db instance
    companion object {
        @Volatile
        private var INSTANCE: AppDb? = null

        fun getDatabase(context: Context): AppDb {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDb::class.java,
                    "User_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}