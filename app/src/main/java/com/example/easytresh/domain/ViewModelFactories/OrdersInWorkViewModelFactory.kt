package com.example.easytresh.domain.ViewModelFactories

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.easytresh.domain.workersViewModles.OrderDetailViewModel
import com.example.easytresh.domain.workersViewModles.OrdersInWorkViewModel

class OrdersInWorkViewModelFactory(application: Application): ViewModelProvider.Factory {
    var app = application
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return OrdersInWorkViewModel(app) as T
    }
}