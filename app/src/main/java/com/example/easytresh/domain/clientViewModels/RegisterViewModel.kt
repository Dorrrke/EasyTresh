package com.example.easytresh.domain.clientViewModels

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.easytresh.MainApp
import com.example.easytresh.domain.BaseViewModel
import com.example.easytresh.repository.AppRepository
import com.example.easytresh.repository.database.entity.Users
import com.example.easytresh.repository.database.pojo.ClientPojoItem
import com.example.easytresh.repository.database.pojo.OrdersPojoItem
import com.example.easytresh.repository.server.ServerApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.properties.Delegates

class RegisterViewModel(application: Application) : BaseViewModel(application) {

    @Inject
    lateinit var repository: AppRepository

    @Inject
    lateinit var server: ServerApi

    private val compositeDisposable = CompositeDisposable()

    var liveData = MutableLiveData<Boolean>()


    init {
        (application as MainApp).appComponent.inject(this)
    }

    fun checkClientFields(
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

    fun addClient(fullName: String, phone: String, pass: String) {
        var currentDate = Date()
        var dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        var data = dateFormat.format(currentDate)

        compositeDisposable.add(server.createClient(Users(0, fullName, phone, pass, data))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.message!!) }
            .subscribe{ it -> liveData.value = it.toBoolean() })
    }

    fun addingClientResult(): MutableLiveData<Boolean>
    {
        return liveData
    }


}