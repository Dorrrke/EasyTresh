package com.example.easytresh.domain.workersViewModles

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.easytresh.MainApp
import com.example.easytresh.domain.BaseViewModel
import com.example.easytresh.repository.database.entity.OrderFull
import com.example.easytresh.repository.database.pojo.AddressesPojoItem
import com.example.easytresh.repository.database.pojo.NotRelevantOrdersPojoItem
import com.example.easytresh.repository.database.pojo.OrdersPojoItem
import com.example.easytresh.repository.server.ServerApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class OrderDetailViewModel(application: Application) : BaseViewModel(application) {


    @Inject
    lateinit var server: ServerApi

    init {
        (application as MainApp).appComponent.inject(this)
    }

    private val compositeDisposable = CompositeDisposable()

    private var addressLiveData = MutableLiveData<AddressesPojoItem>()
    private var orderLiveData = MutableLiveData<OrdersPojoItem>()
    private var resultAddingLiveData = MutableLiveData<String>()
    private var resultDeletingLiveData = MutableLiveData<String>()
    private var resultCompleteLiveData = MutableLiveData<String>()
    private var checkOrdersLiveData = MutableLiveData<NotRelevantOrdersPojoItem>()


    fun getOrderById(id: Int) {
        compositeDisposable.add(server.getOrderById(id)
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

    fun getOrder(): MutableLiveData<OrdersPojoItem> {
        return orderLiveData
    }

    fun getAddress(): MutableLiveData<AddressesPojoItem> {
        return addressLiveData
    }

    fun catchOrder(notRelevantOrdersPojoItem: NotRelevantOrdersPojoItem) {
        compositeDisposable.add(server.addNOrder(notRelevantOrdersPojoItem)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.stackTrace.toString()) }
            .subscribe { it -> resultAddingLiveData.value = it })
    }

    fun deleteOrder(id: Int) {
        compositeDisposable.add(server.deleteOrder(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.stackTrace.toString()) }
            .subscribe { it -> resultDeletingLiveData.value = it })
    }

    fun getResultAdding(): MutableLiveData<String> {
        return resultAddingLiveData
    }

    fun getResultDeleting(): MutableLiveData<String> {
        return resultDeletingLiveData
    }


    fun completeOrder(id: Int){
        compositeDisposable.add(server.getNOrderByWorkerId(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.stackTrace.toString()) }
            .subscribe { it -> updateStateOrder(it[0].orderId!!) }) ///Исправить!!!
    }

    private fun updateStateOrder(id: Int){
        compositeDisposable.add(server.updateNOrder(id, false)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.stackTrace.toString()) }
            .subscribe { it -> resultCompleteLiveData.value = it })
    }

    fun getResultComplete(): MutableLiveData<String> {
        return resultCompleteLiveData
    }

    fun getCheckOrders(): MutableLiveData<NotRelevantOrdersPojoItem> {
        return checkOrdersLiveData
    }


}