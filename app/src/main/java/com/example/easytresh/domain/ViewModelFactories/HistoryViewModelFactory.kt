package com.example.easytresh.domain.ViewModelFactories

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.easytresh.domain.HistoryViewModel
import com.example.easytresh.domain.LoginViewModel

class HistoryViewModelFactory (application: Application): ViewModelProvider.Factory {
    var app = application
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HistoryViewModel(app) as T
    }
}