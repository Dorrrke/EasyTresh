package com.example.easytresh.domain.ViewModelFactories

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.easytresh.domain.clientViewModels.ProfileViewModel
import com.example.easytresh.domain.workersViewModles.WorkerProfileViewModel

class WorkerProfileViewModelFactory (application: Application): ViewModelProvider.Factory {
    var app = application
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WorkerProfileViewModel(app) as T
    }
}