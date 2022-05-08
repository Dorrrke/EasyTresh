package com.example.easytresh.di.component

import com.example.easytresh.di.module.DatabaseModule
import com.example.easytresh.di.module.RepositoryModule
import com.example.easytresh.di.module.ViewModelModule
import com.example.easytresh.presentation.client_screens.*
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ViewModelModule::class, RepositoryModule::class, DatabaseModule::class])
@Singleton
interface AppComponent {
    fun inject (fragment: MainFragment)
    fun inject (fragment: HistoryFragment)
    fun inject (fragment: LoginFragment)
    fun inject (fragment: RegisterFragment)
    fun inject (fragment: OrderFragment)
    fun inject (fragment: ProfileFragment)
}