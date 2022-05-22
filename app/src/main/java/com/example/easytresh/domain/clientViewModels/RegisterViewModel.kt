package com.example.easytresh.domain.clientViewModels

import android.app.Application
import com.example.easytresh.MainApp
import com.example.easytresh.domain.BaseViewModel
import com.example.easytresh.repository.AppRepository
import com.example.easytresh.repository.database.entity.Users
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class RegisterViewModel(application: Application) : BaseViewModel(application) {

    @Inject
    lateinit var repository: AppRepository

    init {
        (application as MainApp).appComponent.inject(this)
    }


    fun correctValue(fullName: String, phone: String, pass: String, repeatPass: String): Boolean {

        var currentDate = Date()
        var dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val regexStr = "^\\+?[78][-\\(]?\\d{3}\\)?-?\\d{3}-?\\d{2}-?\\d{2}\$".toRegex()
        var data = dateFormat.format(currentDate)
        return if (phone.matches(regexStr)) {
            if (pass == repeatPass) {
                repository.insertUser(Users(0, fullName, phone, pass, data))
                true
            } else
                false
        } else
            false
    }


}