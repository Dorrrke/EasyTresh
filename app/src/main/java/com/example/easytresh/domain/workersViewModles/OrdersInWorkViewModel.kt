package com.example.easytresh.domain.workersViewModles

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.easytresh.MainApp
import com.example.easytresh.domain.BaseViewModel
import com.example.easytresh.repository.database.pojo.NotRelevantOrdersPojoItem
import com.example.easytresh.repository.server.ServerApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class OrdersInWorkViewModel(application: Application) : BaseViewModel(application) {

    @Inject
    lateinit var server: ServerApi

    init {
        (application as MainApp).appComponent.inject(this)
    }

    private val compositeDisposable = CompositeDisposable()
    private var checkOrdersLiveData = MutableLiveData<List<NotRelevantOrdersPojoItem>>()

    fun checkOrders(id: Int){
        compositeDisposable.add(server.getNOrderByWorkerId(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.stackTrace.toString()) }
            .subscribe { it -> checkOrdersLiveData.value = it })
    }

    fun getOrders(): MutableLiveData<List<NotRelevantOrdersPojoItem>> {
        return checkOrdersLiveData
    }
}