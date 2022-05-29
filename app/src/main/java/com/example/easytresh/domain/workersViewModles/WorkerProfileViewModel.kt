package com.example.easytresh.domain.workersViewModles

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.easytresh.MainApp
import com.example.easytresh.domain.BaseViewModel
import com.example.easytresh.repository.AppRepository
import com.example.easytresh.repository.database.pojo.ClientPojoItem
import com.example.easytresh.repository.database.pojo.WorkersPojoItem
import com.example.easytresh.repository.server.ServerApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WorkerProfileViewModel (application: Application): BaseViewModel(application) {

    @Inject
    lateinit var repository: AppRepository

    @Inject
    lateinit var server: ServerApi

    init {
        (application as MainApp).appComponent.inject(this)
    }

    var clientLiveData = MutableLiveData<WorkersPojoItem>()

    val compositeDisposable = CompositeDisposable()

    fun catchWorker(id: Int) {
        compositeDisposable.add(server.getWorkerById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.stackTrace.toString()) }
            .subscribe{it -> clientLiveData.value = it})
    }

    fun getWorker(): MutableLiveData<WorkersPojoItem> {
        return clientLiveData
    }
}