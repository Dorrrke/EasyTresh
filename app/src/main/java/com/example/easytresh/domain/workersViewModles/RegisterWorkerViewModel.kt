package com.example.easytresh.domain.workersViewModles

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.easytresh.MainApp
import com.example.easytresh.domain.BaseViewModel
import com.example.easytresh.repository.AppRepository
import com.example.easytresh.repository.database.entity.Users
import com.example.easytresh.repository.database.pojo.WorkersPojoItem
import com.example.easytresh.repository.server.ServerApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class RegisterWorkerViewModel(application: Application) : BaseViewModel(application) {

    @Inject
    lateinit var repository: AppRepository

    @Inject
    lateinit var server: ServerApi

    private val compositeDisposable = CompositeDisposable()

    var liveData = MutableLiveData<Boolean>()


    init {
        (application as MainApp).appComponent.inject(this)
    }

    fun checkWorkerFields(
        fullName: String,
        phone: String,
        pass: String,
        repeatPass: String
    ): Boolean {
        val regexStr = "^\\+?[78][-\\(]?\\d{3}\\)?-?\\d{3}-?\\d{2}-?\\d{2}\$".toRegex()
        return if (phone.matches(regexStr)) {
            pass == repeatPass
        } else
            false
    }

    fun addWorker(fullName: String, phone: String, pass: String){
        var currentDate = Date()
        var dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        var data = dateFormat.format(currentDate)

        compositeDisposable.add(server.createWorker(WorkersPojoItem(null, pass, phone, fullName, data))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.message!!) }
            .subscribe{ it -> liveData.value = it.toBoolean()})
    }

    fun addingWorkerResult(): MutableLiveData<Boolean>
    {
        return liveData
    }


}