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
import kotlin.properties.Delegates

class DetailViewModel(application: Application): BaseViewModel(application)  {
    private val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var repository: AppRepository

    @Inject
    lateinit var server: ServerApi

    var addressId by Delegates.notNull<Int>()

    var addressLiveData = MutableLiveData<List<AddressesPojoItem>>()


    init {
        addressId = -1
        (application as MainApp).appComponent.inject(this)
    }


    fun choseAddress(id: Int){
        addressId = id
    }


    fun getAddressesList(id: Int){
        compositeDisposable.add(server.getAddressesByClientId(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.stackTrace.toString()) }
            .subscribe{ it -> addressLiveData.value = it })
    }

    fun getAddresses(): MutableLiveData<List<AddressesPojoItem>> {
        return addressLiveData
    }
}