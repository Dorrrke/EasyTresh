package com.example.easytresh.di.component

import com.example.easytresh.di.module.DatabaseModule
import com.example.easytresh.presentation.client_screens.*
import dagger.Component
import javax.inject.Singleton

@Component(modules = [DatabaseModule::class])
@Singleton
interface AppComponent {
    fun inject (fragment: MainFragment)
    fun inject (fragment: HistoryFragment)
    fun inject (fragment: LoginFragment)
    fun inject (fragment: OrderFragment)
    fun inject (fragment: ProfileFragment)
}