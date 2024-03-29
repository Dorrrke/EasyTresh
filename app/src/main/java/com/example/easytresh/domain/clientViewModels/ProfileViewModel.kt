package com.example.easytresh.domain.clientViewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.easytresh.MainApp
import com.example.easytresh.domain.BaseViewModel
import com.example.easytresh.repository.AppRepository
import com.example.easytresh.repository.database.entity.Users
import com.example.easytresh.repository.database.pojo.ClientPojoItem
import com.example.easytresh.repository.server.ServerApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ProfileViewModel(application: Application): BaseViewModel(application) {

    @Inject
    lateinit var repository: AppRepository

    @Inject
    lateinit var server: ServerApi

    init {
        (application as MainApp).appComponent.inject(this)
    }

    var clientLiveData = MutableLiveData<ClientPojoItem>()

    val compositeDisposable = CompositeDisposable()

    fun catchClient(id: Int) {
        compositeDisposable.add(server.getClientById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.stackTrace.toString()) }
            .subscribe{it -> clientLiveData.value = it})
    }

    fun getClient(): MutableLiveData<ClientPojoItem> {
        return clientLiveData
    }
}