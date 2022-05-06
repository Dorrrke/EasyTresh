package com.example.easytresh.domain

import android.app.Application
import com.example.easytresh.repository.AppRepository

class HistoryViewModel(application: Application, private val repository: AppRepository): BaseViewModel(application) {
    fun hello(): String
    {
        return repository.hello()
    }
}