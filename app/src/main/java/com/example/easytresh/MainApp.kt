package com.example.easytresh

import android.app.Application
import androidx.room.Room
import com.example.easytresh.di.component.AppComponent
import com.example.easytresh.di.component.DaggerAppComponent
import com.example.easytresh.di.module.DatabaseModule
import com.example.easytresh.di.module.RepositoryModule
import com.example.easytresh.di.module.ViewModelModule
import com.example.easytresh.repository.database.AppDatabase

class MainApp : Application(){

    lateinit var appComponent: AppComponent
    private var database: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        initRoom()
        intiDagger()
    }

    fun initRoom() {
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .allowMainThreadQueries()
            .build()
    }

    fun intiDagger() {
        appComponent = DaggerAppComponent.builder()
            .databaseModule(DatabaseModule(this!!.database!!))
            .viewModelModule(ViewModelModule(this))
            .repositoryModule(RepositoryModule())
            .build()
    }
}
//val Context.appComponent: AppComponent
//    get() = when (this) {
//        is MainApp -> appComponent
//        else -> this.applicationContext.appComponent
//    }