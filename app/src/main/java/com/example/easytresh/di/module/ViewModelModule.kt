package com.example.easytresh.di.module


import android.app.Application
import com.example.easytresh.MainApp
import com.example.easytresh.domain.HistoryViewModel
import com.example.easytresh.repository.AppRepository
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule(app: MainApp){

    internal var app: Application = app

    @Provides
    internal fun providesHistoryViewModel(repository: AppRepository) : HistoryViewModel{
        return HistoryViewModel(app, repository)
    }
}