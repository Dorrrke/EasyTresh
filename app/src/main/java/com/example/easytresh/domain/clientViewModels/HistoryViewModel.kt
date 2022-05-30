package com.example.easytresh.domain.clientViewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.easytresh.MainApp
import com.example.easytresh.domain.BaseViewModel
import com.example.easytresh.repository.AppRepository
import com.example.easytresh.repository.database.pojo.NotRelevantOrdersPojoItem
import com.example.easytresh.repository.database.pojo.OrdersPojoItem
import com.example.easytresh.repository.server.ServerApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HistoryViewModel(application: Application): BaseViewModel(application) {

    var ordersDataItems = MutableLiveData<List<OrdersPojoItem>>()
    var completeOrdersDataItems = MutableLiveData<List<NotRelevantOrdersPojoItem>>()
    private val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var repository: AppRepository

    @Inject
    lateinit var server: ServerApi

    init {
        (application as MainApp).appComponent.inject(this)
    }

    fun getOrders(userId: Int) {
        server?.let {
            compositeDisposable.add(server.getOrdersByUserId(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.message!!) }
                .subscribe { list -> ordersDataItems.value = list})
        }
    }

    fun getCompleteOrders(userId: Int){
        server?.let {
            compositeDisposable.add(server.getNOrdersByUserId(userId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.message!!) }
                .subscribe { list -> completeOrdersDataItems.value = list})
        }
    }

    fun getAllOrders(): MutableLiveData<List<OrdersPojoItem>> {
        return ordersDataItems
    }

    fun getAllCompleteOrders(): MutableLiveData<List<NotRelevantOrdersPojoItem>> {
        return completeOrdersDataItems
    }
}