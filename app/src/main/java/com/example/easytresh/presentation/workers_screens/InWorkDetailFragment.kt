package com.example.easytresh.presentation.workers_screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.ViewModelFactories.InWorkDetailViewModelFactory
import com.example.easytresh.domain.workersViewModles.InWorkDetailViewModel
import com.example.easytresh.repository.database.pojo.AddressesPojoItem
import com.example.easytresh.repository.database.pojo.NotRelevantOrdersPojoItem

class InWorkDetailFragment : Fragment(R.layout.fragment_in_work_detail) {

    companion object {
        const val orderKey = "ORDER_ID"
    }

    var orderId = -1

    lateinit var viewModel: InWorkDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            InWorkDetailViewModelFactory(activity?.application as MainApp)
        ).get(InWorkDetailViewModel::class.java)

        orderId = arguments?.get(OrderDetailFragment.orderKey) as Int
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getOrderById(orderId)
        viewModel.getOrder().observe(viewLifecycleOwner, Observer { initOrderFields(it) })
        viewModel.getAddress().observe(viewLifecycleOwner, Observer { initAddressFields(it) })
        var completeBtn = view.findViewById<Button>(R.id.completeWorkOrderBtn)
        completeBtn.setOnClickListener {
            viewModel.updateStateOrder(orderId)
            viewModel.getResultComplete().observe(viewLifecycleOwner, Observer { completeResult(it) })

        }

    }

    private fun completeResult(it: String?) {
        val toast =
            Toast.makeText(context, "Заказ выполнен. Результат $it", Toast.LENGTH_SHORT)
        toast.show()
    }

    private fun initAddressFields(it: AddressesPojoItem?) {
        if (it != null) {
            view?.findViewById<TextView>(R.id.cityDetailWork)?.text = it.city
            view?.findViewById<TextView>(R.id.streetDetailWork)?.text = it.street
            view?.findViewById<TextView>(R.id.houseDetailWork)?.text = it.houseNumber.toString()
            view?.findViewById<TextView>(R.id.frameDetailWork)?.text = it.frame.toString()
            view?.findViewById<TextView>(R.id.doorDetailWork)?.text = it.frontDoor.toString()
            view?.findViewById<TextView>(R.id.floorDetailWork)?.text = it.floor.toString()
            view?.findViewById<TextView>(R.id.flatDetailWork)?.text = it.flat.toString()
        }
    }

    private fun initOrderFields(it: NotRelevantOrdersPojoItem?) {
        if (it != null) {
            view?.findViewById<TextView>(R.id.orderDataFieldWork)?.text = it.date
            view?.findViewById<TextView>(R.id.orderRelevanceFieldWork)?.text = it.relevance.toString()
            view?.findViewById<TextView>(R.id.orderTrashTypeFieldWork)?.text = it.trashType
            view?.findViewById<TextView>(R.id.orderSizeFieldWork)?.text = it.size
        }
    }

}