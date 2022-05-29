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

class LoginWorkerViewModel(application: Application): BaseViewModel(application) {

    @Inject
    lateinit var server: ServerApi

    @Inject
    lateinit var repository: AppRepository

    var liveDataRes = MutableLiveData<Boolean>()

    var workerLiveData = MutableLiveData<WorkersPojoItem>()

    private val compositeDisposable = CompositeDisposable()

    init {
        (application as MainApp).appComponent.inject(this)
    }

    fun verification(phone: String, pass: String) {

        compositeDisposable.add(server.checkWorker(WorkersPojoItem(null, pass, phone, null, null))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.message!!) }
            .subscribe { it -> liveDataRes.value = it.toBoolean() })
    }

    fun resultVerification(): MutableLiveData<Boolean> {
        return liveDataRes
    }

    fun catchWorker(phone: String) {
        compositeDisposable.add(server.getWorker(WorkersPojoItem(null,null,phone,null,null))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.message!!) }
            .subscribe{it -> workerLiveData.value = it})
    }

    fun getWorker(): MutableLiveData<WorkersPojoItem> {
        return workerLiveData
    }
}