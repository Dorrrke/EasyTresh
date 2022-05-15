package com.example.easytresh.domain.ViewModelFactories

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.easytresh.domain.LoginViewModel
import com.example.easytresh.domain.RegisterViewModel

class RegisterViewModelFactory (application: Application): ViewModelProvider.Factory {
    var app = application
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RegisterViewModel(app) as T
    }
}