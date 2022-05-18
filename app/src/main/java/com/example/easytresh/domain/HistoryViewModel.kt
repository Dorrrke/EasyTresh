package com.example.easytresh.domain

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Index
import com.example.easytresh.MainApp
import com.example.easytresh.presentation.widget.SingleLiveEvent
import com.example.easytresh.repository.AppRepository
import com.example.easytresh.repository.database.entity.Orders
import javax.inject.Inject

class HistoryViewModel(application: Application): BaseViewModel(application) {

    private val liveDataItems = SingleLiveEvent<Orders>()

    @Inject
    lateinit var repository: AppRepository

    init {
        (application as MainApp).appComponent.inject(this)
    }

    fun getAllOrders(): LiveData<List<Orders>> {
        var res = repository.getAllOrders().value
        return repository.getAllOrders()
    }
}