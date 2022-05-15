package com.example.easytresh.domain.ViewModelFactories

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.easytresh.domain.LoginViewModel

class LoginViewModelFactory(app: Application): ViewModelProvider.Factory {
    var appp = app
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(appp) as T
    }

}