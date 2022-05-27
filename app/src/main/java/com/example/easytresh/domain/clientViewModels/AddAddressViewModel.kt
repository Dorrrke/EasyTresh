package com.example.easytresh.domain.clientViewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.easytresh.MainApp
import com.example.easytresh.domain.BaseViewModel
import com.example.easytresh.repository.AppRepository
import com.example.easytresh.repository.database.pojo.AddressesPojoItem
import com.example.easytresh.repository.server.ServerApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AddAddressViewModel(application: Application) : BaseViewModel(application) {
    private val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var repository: AppRepository

    @Inject
    lateinit var server: ServerApi

    var resLiveData = MutableLiveData<String>()

    init {
        (application as MainApp).appComponent.inject(this)
    }


    fun addAddress(addressesPojoItem: AddressesPojoItem) {
        compositeDisposable.add(
            server.addAddress(addressesPojoItem)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.stackTrace.toString()) }
                .subscribe { it ->
                    Log.e(" Add Result", it.toString())
                    resLiveData.value = it
                })
    }

    fun getResult(): MutableLiveData<String> {
        return resLiveData
    }
}