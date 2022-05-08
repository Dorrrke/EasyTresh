package com.example.easytresh.di.module


import android.app.Application
import com.example.easytresh.MainApp
import com.example.easytresh.domain.*
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

    @Provides
    internal fun providesOrderViewModel(repository: AppRepository) : OrderViewModel{
        return OrderViewModel(app, repository)
    }

    @Provides
    internal fun providesProfileViewModel(repository: AppRepository) : ProfileViewModel{
        return ProfileViewModel(app, repository)
    }

    @Provides
    internal fun providesRegisterViewModel(repository: AppRepository) : RegisterViewModel{
        return RegisterViewModel(app, repository)
    }

    @Provides
    internal fun providesLoginViewModel(repository: AppRepository) : LoginViewModel{
        return LoginViewModel(app, repository)
    }
}