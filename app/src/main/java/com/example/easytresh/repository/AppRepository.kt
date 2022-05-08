package com.example.easytresh.repository

import androidx.lifecycle.LiveData
import com.example.easytresh.repository.database.AppDatabase
import com.example.easytresh.repository.database.entity.Users
import io.reactivex.Single

class AppRepository (private val database: AppDatabase){

    fun insertUser(user: Users)
    {
        database.UsersDao().insert(user)
    }

    fun getUserByNumber(phone: String):Users{
        return database.UsersDao().getUserByPhone(phone)
    }

    fun getAll(): List<Users> {
        return database.UsersDao().getAllUsers()
    }
}