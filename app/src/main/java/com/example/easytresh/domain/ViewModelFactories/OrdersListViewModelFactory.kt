package com.example.easytresh.domain.ViewModelFactories

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.easytresh.domain.workersViewModles.OrdersListViewModel
import com.example.easytresh.domain.workersViewModles.RegisterWorkerViewModel

class OrdersListViewModelFactory(application: Application): ViewModelProvider.Factory {
    var app = application
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return OrdersListViewModel(app) as T
    }
}