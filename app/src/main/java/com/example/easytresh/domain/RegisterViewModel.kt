package com.example.easytresh.domain

import android.app.Application
import com.example.easytresh.MainApp
import com.example.easytresh.repository.AppRepository
import com.example.easytresh.repository.database.entity.Users
import javax.inject.Inject

class RegisterViewModel(application: Application): BaseViewModel(application) {

    @Inject
    lateinit var repository: AppRepository

    init {
        (application as MainApp).appComponent.inject(this)
    }


    fun correctValue(fullName: String, phone: String, pass: String, repeatPass: String) : Boolean{

        val regexStr ="^\\+?[78][-\\(]?\\d{3}\\)?-?\\d{3}-?\\d{2}-?\\d{2}\$".toRegex()
        return if(phone.matches(regexStr)) {
            if (pass == repeatPass) {
                repository.insertUser(Users(0, fullName, phone, pass))
                true
            } else
                false
        } else
            false
    }



}