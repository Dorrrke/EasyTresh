package com.example.easytresh.domain

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.easytresh.MainApp
import com.example.easytresh.repository.AppRepository
import com.example.easytresh.repository.database.entity.Users
import javax.inject.Inject

class LoginViewModel(application: Application): BaseViewModel(application) {


    @Inject
    lateinit var repository: AppRepository

    init {
        (application as MainApp).appComponent.inject(this)
    }

    fun verf(phone: String, pass: String): Users? {
        val user = repository.getUserByNumber(phone)
        return if (user != null){
            if (user.userPhone == phone)
                user
            else
                null
        } else
            null
    }
}