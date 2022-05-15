package com.example.easytresh.di.component

import com.example.easytresh.di.module.DatabaseModule
import com.example.easytresh.di.module.RepositoryModule
import com.example.easytresh.domain.*
import com.example.easytresh.domain.ViewModelFactories.LoginViewModelFactory
import com.example.easytresh.presentation.client_screens.*
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RepositoryModule::class, DatabaseModule::class])
@Singleton
interface AppComponent {
    fun inject (fragment: LoginViewModel)
    fun inject (fragment: AllFragmentsViewModel)
    fun inject (fragment: HistoryViewModel)
    fun inject (fragment: RegisterViewModel)
    fun inject (fragment: OrderViewModel)
    fun inject (fragment: ProfileViewModel)
}