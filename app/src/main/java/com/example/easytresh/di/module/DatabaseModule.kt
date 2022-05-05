package com.example.easytresh.di.module

import com.example.easytresh.repository.database.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule(private val appDatabase: AppDatabase) {

    @Provides
    internal fun providesDatabase(): AppDatabase {
        return appDatabase
    }
}