package com.example.easytresh.domain.workersViewModles

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.easytresh.MainApp
import com.example.easytresh.domain.BaseViewModel
import com.example.easytresh.repository.AppRepository
import com.example.easytresh.repository.database.pojo.AddressesPojoItem
import com.example.easytresh.repository.database.pojo.NotRelevantOrdersPojoItem
import com.example.easytresh.repository.database.pojo.OrdersPojoItem
import com.example.easytresh.repository.server.ServerApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class InWorkDetailViewModel (application: Application) : BaseViewModel(application) {

    private val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var repository: AppRepository

    @Inject
    lateinit var server: ServerApi

    init {
        (application as MainApp).appComponent.inject(this)
    }

    private var addressLiveData = MutableLiveData<AddressesPojoItem>()
    private var orderLiveData = MutableLiveData<NotRelevantOrdersPojoItem>()
    private var resultCompleteLiveData = MutableLiveData<String>()

    fun getOrderById(id: Int) {
        compositeDisposable.add(server.getNOrderById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.stackTrace.toString()) }
            .subscribe { it ->
                orderLiveData.value = it
                getAddressById(it.addressId!!)
            })
    }

    private fun getAddressById(id: Int) {
        compositeDisposable.add(server.getAddressesById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.stackTrace.toString()) }
            .subscribe { it -> addressLiveData.value = it })
    }

    fun getOrder(): MutableLiveData<NotRelevantOrdersPojoItem> {
        return orderLiveData
    }

    fun getAddress(): MutableLiveData<AddressesPojoItem> {
        return addressLiveData
    }

    fun updateStateOrder(id: Int){
        compositeDisposable.add(server.updateNOrder(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.stackTrace.toString()) }
            .subscribe { it -> resultCompleteLiveData.value = it })
    }


    fun getResultComplete(): MutableLiveData<String> {
        return resultCompleteLiveData
    }
}