package com.example.easytresh.repository.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.easytresh.repository.database.dao.UsersDao

abstract class AppDatabase: RoomDatabase() {

    abstract fun UsersDao(): UsersDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getAppDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "room-kotlin-database"
                ).build()
            }
            return INSTANCE
        }
    }
}