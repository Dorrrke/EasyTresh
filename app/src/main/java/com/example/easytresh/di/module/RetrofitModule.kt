package com.example.easytresh.di.module

import com.example.easytresh.repository.AppRepository
import com.example.easytresh.repository.database.AppDatabase
import com.example.easytresh.repository.server.ServerApi
import com.example.easytresh.repository.server.ServerCommunicator
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun httpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { this.level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Singleton
    fun httpClient( httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    @Singleton
     fun retrofit(okHttpClient: OkHttpClient): Retrofit =
         Retrofit.Builder()
             .baseUrl("http://192.168.56.1:8080")
             .client(okHttpClient)
             .addConverterFactory(GsonConverterFactory.create())
             .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
             .build()

    @Provides
    @Singleton
    fun provideRetrofit(retrofit: Retrofit): ServerApi =
        retrofit.create(ServerApi::class.java)

}