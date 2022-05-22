package com.example.easytresh.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.easytresh.repository.database.dao.*
import com.example.easytresh.repository.database.entity.*

@Database(entities = [Users::class, Orders::class, Addresses::class, Workers::class, NotRelevantOrders::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun UsersDao(): UsersDao
    abstract fun OrdersDao(): OrdersDao
    abstract fun AddressesDao(): AddressesDao
    abstract fun NotRelevantOrdersDao(): NotRelevantOrdersDao
    abstract fun WorkersDao(): WorkersDao

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