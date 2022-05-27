package com.example.easytresh.domain.ViewModelFactories

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.easytresh.domain.clientViewModels.DetailViewModel
import com.example.easytresh.domain.clientViewModels.HistoryViewModel

class DetailViewModelFactory(application: Application): ViewModelProvider.Factory {
    var app = application
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(app) as T
    }
}
