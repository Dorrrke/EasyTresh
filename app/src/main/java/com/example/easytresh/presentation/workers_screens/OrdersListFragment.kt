package com.example.easytresh.presentation.workers_screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.ViewModelFactories.OrdersListViewModelFactory
import com.example.easytresh.domain.workersViewModles.OrdersListViewModel
import com.example.easytresh.presentation.adapters.OrdersListAdapter
import com.example.easytresh.repository.database.pojo.OrdersPojoItem

class OrdersListFragment : Fragment(R.layout.fragment_workers_orders_list) {

    lateinit var viewModel: OrdersListViewModel
    lateinit var ordersListRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, OrdersListViewModelFactory(activity?.application as MainApp)).get(
            OrdersListViewModel::class.java
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ordersListRecycler = view.findViewById<RecyclerView>(R.id.recyclerOrdersList)
        viewModel.getOrders()
        viewModel.getAllOrders().observe(viewLifecycleOwner, Observer { initRecyclerView(it) })
    }

    private fun initRecyclerView(it: List<OrdersPojoItem>) {
        val navController = findNavController()
        val recAdapter = OrdersListAdapter(it!!, activity?.application as MainApp, navController)
        ordersListRecycler.layoutManager = LinearLayoutManager(context)
        ordersListRecycler.adapter = recAdapter
    }

}