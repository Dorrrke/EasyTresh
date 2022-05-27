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

class LoginViewModel(application: Application) : BaseViewModel(application) {

    @Inject
    lateinit var server: ServerApi

    @Inject
    lateinit var repository: AppRepository

    var liveDataRes = MutableLiveData<Boolean>()

    var clientLiveData = MutableLiveData<ClientPojoItem>()

    val compositeDisposable = CompositeDisposable()

    init {
        (application as MainApp).appComponent.inject(this)
    }

    fun verification(phone: String, pass: String) {

        compositeDisposable.add(server.checkClient(ClientPojoItem(pass, phone, null, null, null))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.message!!) }
            .subscribe { it -> liveDataRes.value = it.toBoolean() })
    }

    fun resultVerification(): MutableLiveData<Boolean> {
        return liveDataRes
    }

    fun catchClient(phone: String) {
        compositeDisposable.add(server.getClient(ClientPojoItem(null, phone, null, null, null))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.message!!) }
            .subscribe{it -> clientLiveData.value = it})
    }

    fun getClient(): MutableLiveData<ClientPojoItem> {
        return clientLiveData
    }
}