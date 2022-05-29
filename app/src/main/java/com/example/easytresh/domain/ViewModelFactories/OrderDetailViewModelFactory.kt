package com.example.easytresh.domain.ViewModelFactories

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.easytresh.domain.workersViewModles.LoginWorkerViewModel
import com.example.easytresh.domain.workersViewModles.OrderDetailViewModel

class OrderDetailViewModelFactory(application: Application): ViewModelProvider.Factory {
    var app = application
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return OrderDetailViewModel(app) as T
    }
}