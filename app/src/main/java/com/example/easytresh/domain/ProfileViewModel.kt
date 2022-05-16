package com.example.easytresh.domain

import android.app.Application
import com.example.easytresh.MainApp
import com.example.easytresh.repository.AppRepository
import com.example.easytresh.repository.database.entity.Users
import javax.inject.Inject

class ProfileViewModel(application: Application): BaseViewModel(application) {

    @Inject
    lateinit var repository: AppRepository

    init {
        (application as MainApp).appComponent.inject(this)
    }

    fun getClient(uId: Int): Users {
        return repository.getUserById(uId)
    }
}