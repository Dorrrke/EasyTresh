package com.example.easytresh.domain.ViewModelFactories

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.easytresh.domain.AllFragmentsViewModel
import com.example.easytresh.domain.LoginViewModel

class AllFragmentsViewModelFactory (application: Application): ViewModelProvider.Factory {
    var app = application
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AllFragmentsViewModel(app) as T
    }
}