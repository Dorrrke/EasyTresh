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
import com.example.easytresh.domain.ViewModelFactories.OrdersInWorkViewModelFactory
import com.example.easytresh.domain.workersViewModles.OrdersInWorkViewModel
import com.example.easytresh.presentation.adapters.OrdersInWorkAdapter
import com.example.easytresh.presentation.adapters.OrdersListAdapter
import com.example.easytresh.repository.database.pojo.NotRelevantOrdersPojoItem

class OrdersInWorkFragment : Fragment(R.layout.fragment_orders_in_work) {

    lateinit var viewModel: OrdersInWorkViewModel
    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, OrdersInWorkViewModelFactory(activity?.application as MainApp)).get(
            OrdersInWorkViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = view.findViewById(R.id.recyclerOrdersInWork)
        viewModel.checkOrders(MainWorkerFragment.workerId)
        viewModel.getOrders().observe(viewLifecycleOwner, Observer { initRecycler(it) })
    }

    private fun initRecycler(it: List<NotRelevantOrdersPojoItem>?) {
        val navController = findNavController()
        val recAdapter = OrdersInWorkAdapter(it!!, activity?.application as MainApp, navController)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = recAdapter
    }
}