package com.example.easytresh.di.module
//
//
//import android.app.Application
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.easytresh.MainApp
//import com.example.easytresh.domain.AllFragmenViewModel
//import dagger.Binds
//import dagger.Module
//import dagger.multibindings.IntoMap
//
//@Module
//class ViewModelModule(app: MainApp){
//
//    internal var app: Application = app
//
//    @Binds
//    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory\
//
//    @Binds
//    @IntoMap
//    abstract fun allFragmentViewModel(viewmodel: AllFragmenViewModel): ViewModel
//
//    @Provides
//    internal fun providesHistoryViewModel(repository: AppRepository) : HistoryViewModel{
//        return HistoryViewModel(app, repository)
//    }
//
//    @Provides
//    internal fun providesOrderViewModel(repository: AppRepository) : OrderViewModel{
//        return OrderViewModel(app, repository)
//    }
//
//    @Provides
//    internal fun providesProfileViewModel(repository: AppRepository) : ProfileViewModel{
//        return ProfileViewModel(app, repository)
//    }
//
//    @Provides
//    internal fun providesRegisterViewModel(repository: AppRepository) : RegisterViewModel{
//        return RegisterViewModel(app, repository)
//    }
//
//    @Provides
//    internal fun providesLoginViewModel(repository: AppRepository) : LoginViewModel{
//        return LoginViewModel(app, repository)
//    }
//
//    @Provides
//    internal fun providesAllFragmentViewModel(repository: AppRepository) : AllFragmenViewModel{
//        return AllFragmenViewModel(app, repository)
//    }
//}