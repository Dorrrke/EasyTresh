package com.example.easytresh.domain

import android.app.Application
import com.example.easytresh.repository.AppRepository

class OrderViewModel(application: Application, private val repository: AppRepository): BaseViewModel(application) {
}