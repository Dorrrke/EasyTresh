package com.example.easytresh.presentation.workers_screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.ViewModelFactories.OrderDetailViewModelFactory
import com.example.easytresh.domain.workersViewModles.OrderDetailViewModel
import com.example.easytresh.repository.database.pojo.AddressesPojoItem
import com.example.easytresh.repository.database.pojo.NotRelevantOrdersPojoItem
import com.example.easytresh.repository.database.pojo.OrdersPojoItem
import kotlin.properties.Delegates

class OrderDetailFragment : Fragment(R.layout.fragment_order_detail) {

    lateinit var viewModel: OrderDetailViewModel

    var orderId = -1
    var addressId = -1
    var checkOrders = false
    var order = OrdersPojoItem()

    companion object {
        const val orderKey = "ORDER_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            OrderDetailViewModelFactory(activity?.application as MainApp)
        ).get(
            OrderDetailViewModel::class.java
        )
        orderId = arguments?.get(orderKey) as Int
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getOrderById(orderId)
        viewModel.getOrder().observe(viewLifecycleOwner, Observer { initOrderField(it) })
        viewModel.getAddress().observe(viewLifecycleOwner, Observer { initAddressField(it) })

        var catchBtn = view.findViewById<Button>(R.id.chatchOrderBtn)

        catchBtn.setOnClickListener {
                viewModel.catchOrder(
                    NotRelevantOrdersPojoItem(
                        order.date,
                        order.trashType,
                        MainWorkerFragment.workerId,
                        order.clientId,
                        order.size,
                        null,
                        order.relevance,
                        order.addressId
                    )
                )
                viewModel.getResultAdding()
                    .observe(viewLifecycleOwner, Observer { checkResultAdding(it) })

    }
    }


    private fun checkResultAdding(it: String?) {
        if (it.toBoolean()) {
            viewModel.deleteOrder(order.orderId!!)
            viewModel.getResultDeleting()
                .observe(viewLifecycleOwner, Observer { checkResultDeleting(it) })
        }
    }

    private fun checkResultDeleting(it: String?) {
        val toast =
            Toast.makeText(context, "Результат взятия в работу заказа $it", Toast.LENGTH_SHORT)
        toast.show()
    }


    private fun initOrderField(it: OrdersPojoItem) {
        order = it
        view?.findViewById<TextView>(R.id.orderDetailDataField)?.text = it.date
        view?.findViewById<TextView>(R.id.orderDetailRelevanceField)?.text = it.relevance.toString()
        view?.findViewById<TextView>(R.id.orderDetailTrashTypeField)?.text = it.trashType
        view?.findViewById<TextView>(R.id.orderDetailSizeField)?.text = it.size
    }

    private fun initAddressField(it: AddressesPojoItem) {
        view?.findViewById<TextView>(R.id.cityDetail)?.text = it.city
        view?.findViewById<TextView>(R.id.streetDetail)?.text = it.street
        view?.findViewById<TextView>(R.id.houseDetail)?.text = it.houseNumber.toString()
        view?.findViewById<TextView>(R.id.frameDetail)?.text = it.frame.toString()
        view?.findViewById<TextView>(R.id.doorDetail)?.text = it.frontDoor.toString()
        view?.findViewById<TextView>(R.id.floorDetail)?.text = it.floor.toString()
        view?.findViewById<TextView>(R.id.flatDetail)?.text = it.flat.toString()
    }
}