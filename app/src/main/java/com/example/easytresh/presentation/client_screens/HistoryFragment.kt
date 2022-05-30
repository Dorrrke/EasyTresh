package com.example.easytresh.presentation.client_screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.clientViewModels.HistoryViewModel
import com.example.easytresh.domain.ViewModelFactories.HistoryViewModelFactory
import com.example.easytresh.presentation.adapters.CompleteOrdersAdapter
import com.example.easytresh.presentation.adapters.OrdersAdapter
import com.example.easytresh.repository.database.pojo.NotRelevantOrdersPojoItem
import com.example.easytresh.repository.database.pojo.OrdersPojoItem

class HistoryFragment() : Fragment(R.layout.fragment_history) {


    lateinit var viewModel: HistoryViewModel
    lateinit var ordersView: RecyclerView
    lateinit var completeOrdersView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, HistoryViewModelFactory(activity?.application as MainApp)).get(
            HistoryViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ordersView = view.findViewById<RecyclerView>(R.id.recyclerView)
        completeOrdersView = view.findViewById(R.id.recyclerActivityView)
        viewModel.getOrders(MainFragment.userId)
        viewModel.getCompleteOrders(MainFragment.userId)
        viewModel.getAllOrders().observe(viewLifecycleOwner, Observer { it?.let { initRecyclerView(it) } })
        viewModel.getAllCompleteOrders().observe(viewLifecycleOwner, Observer { it?.let { initRecyclerActivityView(it) } })
    }

    private fun initRecyclerActivityView(it: List<NotRelevantOrdersPojoItem>) {
        var adapter = CompleteOrdersAdapter(it, activity?.application as MainApp)
        completeOrdersView.layoutManager = LinearLayoutManager(context)
        completeOrdersView.adapter = adapter

    }

    private fun initRecyclerView(orders: List<OrdersPojoItem>) {
        val orderAdapter = OrdersAdapter(orders, activity?.application as MainApp)
        ordersView.layoutManager = LinearLayoutManager(context)
        ordersView.adapter = orderAdapter
    }


}