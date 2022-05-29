package com.example.easytresh.domain.clientViewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.easytresh.MainApp
import com.example.easytresh.domain.BaseViewModel
import com.example.easytresh.repository.AppRepository
import com.example.easytresh.repository.database.entity.Addresses
import com.example.easytresh.repository.database.entity.Orders
import com.example.easytresh.repository.database.pojo.AddressesPojoItem
import com.example.easytresh.repository.database.pojo.ClientPojoItem
import com.example.easytresh.repository.database.pojo.OrdersPojoItem
import com.example.easytresh.repository.server.ServerApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.properties.Delegates

class OrderViewModel(application: Application) : BaseViewModel(application) {
    @Inject
    lateinit var repository: AppRepository

    @Inject
    lateinit var server: ServerApi

    private val compositeDisposable = CompositeDisposable()

    private var addressLiveData = MutableLiveData<AddressesPojoItem>()

    var resultAddingLiveData = MutableLiveData<String>()

    var adrrId = -1


    init {
        (application as MainApp).appComponent.inject(this)
    }

    fun getAddressById(){
        compositeDisposable.add(server.getAddressesById(adrrId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.stackTrace.toString()) }
            .subscribe{ it -> addressLiveData.value = it })
    }

    fun getAddress(): MutableLiveData<AddressesPojoItem> {
        return addressLiveData
    }

    fun setAddrId(id: Int)
    {
        adrrId = id
    }

    fun setUpOrder(adr: AddressesPojoItem, order: OrdersPojoItem) {
        var currentDate = Date()
        var dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        var data = dateFormat.format(currentDate)
        order.date = data
        compositeDisposable.add(server.addOrder(order)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.stackTrace.toString()) }
            .subscribe{ it -> resultAddingLiveData.value = it})
    }

    fun getResultAdding(): MutableLiveData<String> {
        return resultAddingLiveData
    }



}