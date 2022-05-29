package com.example.easytresh.di.component

import com.example.easytresh.di.module.DatabaseModule
import com.example.easytresh.di.module.RepositoryModule
import com.example.easytresh.di.module.RetrofitModule
import com.example.easytresh.domain.*
import com.example.easytresh.domain.clientViewModels.*
import com.example.easytresh.domain.workersViewModles.*
import com.example.easytresh.presentation.adapters.OrdersAdapter
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RepositoryModule::class, DatabaseModule::class, RetrofitModule::class])
@Singleton
interface AppComponent {
    fun inject (viewModel: LoginViewModel)
    fun inject (viewModel: LoginWorkerViewModel)
    fun inject (viewModel: RegisterViewModel)
    fun inject (viewModel: RegisterWorkerViewModel)
    fun inject (viewModel: HistoryViewModel)
    fun inject (viewModel: AllFragmentsViewModel)
    fun inject (viewModel: OrderViewModel)
    fun inject (viewModel: ProfileViewModel)
    fun inject( viewModel: WorkerProfileViewModel)
    fun inject (adapter: OrdersAdapter)
    fun inject (viewModel: DetailViewModel)
    fun inject (viewModel: AddAddressViewModel)
    fun inject (viewModel: OrdersListViewModel)
    fun inject (viewModel: OrderDetailViewModel)
    fun inject(viewModel: OrdersInWorkViewModel)
}