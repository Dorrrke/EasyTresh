package com.example.easytresh.di.component

import com.example.easytresh.di.module.DatabaseModule
import com.example.easytresh.di.module.RepositoryModule
import com.example.easytresh.di.module.RetrofitModule
import com.example.easytresh.domain.*
import com.example.easytresh.domain.clientViewModels.*
import com.example.easytresh.domain.workersViewModles.LoginWorkerViewModel
import com.example.easytresh.domain.workersViewModles.RegisterWorkerViewModel
import com.example.easytresh.presentation.adapters.OrdersAdapter
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RepositoryModule::class, DatabaseModule::class, RetrofitModule::class])
@Singleton
interface AppComponent {
    fun inject (fragment: LoginViewModel)
    fun inject (fragment: LoginWorkerViewModel)
    fun inject (fragment: RegisterViewModel)
    fun inject (fragment: RegisterWorkerViewModel)
    fun inject (fragment: HistoryViewModel)
    fun inject (fragment: AllFragmentsViewModel)
    fun inject (fragment: OrderViewModel)
    fun inject (fragment: ProfileViewModel)
    fun inject (adapter: OrdersAdapter)
    fun inject (fragment: DetailViewModel)
    fun inject (fragment: AddAddressViewModel)
}