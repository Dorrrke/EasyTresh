package com.example.easytresh.domain.ViewModelFactories

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.easytresh.domain.clientViewModels.AddAddressViewModel
import com.example.easytresh.domain.clientViewModels.DetailViewModel

class AddAddressViewModelFactory(application: Application): ViewModelProvider.Factory {
    var app = application
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddAddressViewModel(app) as T
    }
}
