package com.example.easytresh.domain

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.easytresh.repository.AppRepository
import com.example.easytresh.repository.database.entity.Users

class LoginViewModel(application: Application, private val repository: AppRepository): BaseViewModel(application) {



    fun verf(phone: String, pass: String): Boolean {
        val user = repository.getUserByNumber(phone)
        return if (user != null){
            user.userPass == pass
        } else
            false
    }
}