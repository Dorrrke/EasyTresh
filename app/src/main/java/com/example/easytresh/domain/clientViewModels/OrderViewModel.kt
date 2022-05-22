package com.example.easytresh.domain.clientViewModels

import android.app.Application
import com.example.easytresh.MainApp
import com.example.easytresh.domain.BaseViewModel
import com.example.easytresh.repository.AppRepository
import com.example.easytresh.repository.database.entity.Addresses
import com.example.easytresh.repository.database.entity.Orders
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class OrderViewModel(application: Application) : BaseViewModel(application) {
    @Inject
    lateinit var repository: AppRepository

    init {
        (application as MainApp).appComponent.inject(this)
    }

    fun setUpOrder(adr: Addresses, order: Orders) {
        var currentDate = Date()
        var dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        var data = dateFormat.format(currentDate)
        repository.insertAddress(adr)
        var address = repository.getAddressByInfo(order.clientId, adr.street, adr.houseNumber)
        saveOrder(address, order, data)
    }

    private fun saveOrder(it: Addresses, order: Orders, data: String) {
        var correctOrder = Orders(
            order.OrderId,
            data,
            order.type,
            order.size,
            it.id,
            order.clientId
        )
        repository.insertOrder(correctOrder)
    }

}