package com.example.easytresh.presentation.workers_screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.ViewModelFactories.WorkHistoryViewModelFactory
import com.example.easytresh.domain.workersViewModles.WorkHistoryViewModel
import com.example.easytresh.presentation.adapters.CompleteOrdersAdapter
import com.example.easytresh.repository.database.pojo.NotRelevantOrdersPojoItem

class WorkHistoryFragment : Fragment(R.layout.fragment_work_history) {

    lateinit var viewModel: WorkHistoryViewModel
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            WorkHistoryViewModelFactory(activity?.application as MainApp)
        ).get(WorkHistoryViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerHistoryWorkerView)
        viewModel.getOrders(MainWorkerFragment.workerId)
        viewModel.getAllOrders().observe(viewLifecycleOwner, Observer { initRecyclerView(it) })
    }

    private fun initRecyclerView(it: List<NotRelevantOrdersPojoItem>?) {
        var adapter = CompleteOrdersAdapter(it!!, activity?.application as MainApp)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

}