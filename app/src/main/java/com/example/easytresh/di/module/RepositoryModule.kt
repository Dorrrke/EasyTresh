package com.example.easytresh.di.module

import com.example.easytresh.repository.AppRepository
import com.example.easytresh.repository.database.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    internal fun providesRepository(database: AppDatabase): AppRepository{
        return AppRepository(database)
    }
}