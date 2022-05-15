package com.example.easytresh.presentation.client_screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.HistoryViewModel
import com.example.easytresh.domain.OrderViewModel
import com.example.easytresh.domain.ViewModelFactories.HistoryViewModelFactory
import com.example.easytresh.domain.ViewModelFactories.OrderViewModelFactory
import javax.inject.Inject

class OrderFragment : Fragment(R.layout.fragment_order) {


    lateinit var viewModel: OrderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, OrderViewModelFactory(activity?.application as MainApp)).get(
            OrderViewModel::class.java)
    }
}