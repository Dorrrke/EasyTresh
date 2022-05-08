package com.example.easytresh.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.easytresh.repository.database.dao.OrdersDao
import com.example.easytresh.repository.database.dao.UsersDao
import com.example.easytresh.repository.database.entity.Orders
import com.example.easytresh.repository.database.entity.Users

@Database(entities = [Users::class, Orders::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun UsersDao(): UsersDao
    abstract fun OrdersDao(): OrdersDao

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