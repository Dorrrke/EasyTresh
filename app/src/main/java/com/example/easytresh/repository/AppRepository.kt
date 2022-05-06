package com.example.easytresh.repository

import com.example.easytresh.repository.database.AppDatabase

class AppRepository (private val database: AppDatabase){

    fun hello(): String{
        return "Hello"
    }
}