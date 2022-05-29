package com.example.easytresh.domain.workersViewModles

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.easytresh.MainApp
import com.example.easytresh.domain.BaseViewModel
import com.example.easytresh.repository.AppRepository
import com.example.easytresh.repository.database.pojo.OrdersPojo
import com.example.easytresh.repository.database.pojo.OrdersPojoItem
import com.example.easytresh.repository.server.ServerApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class OrdersListViewModel(application: Application) : BaseViewModel(application) {

    var liveDataItems = MutableLiveData<List<OrdersPojoItem>>()
    private val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var repository: AppRepository

    @Inject
    lateinit var server: ServerApi

    init {
        (application as MainApp).appComponent.inject(this)
    }

    fun getOrders() {
        server?.let {
            compositeDisposable.add(server.allRelevantOrders()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.message!!) }
                .subscribe { list -> liveDataItems.value = list})
        }
    }

    fun getAllOrders(): MutableLiveData<List<OrdersPojoItem>> {
        return liveDataItems
    }

}