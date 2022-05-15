package com.example.easytresh.presentation.client_screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.HistoryViewModel
import com.example.easytresh.domain.LoginViewModel
import com.example.easytresh.domain.ViewModelFactories.HistoryViewModelFactory
import com.example.easytresh.domain.ViewModelFactories.LoginViewModelFactory
import javax.inject.Inject

class HistoryFragment() : Fragment(R.layout.fragment_history) {


    lateinit var viewModel: HistoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, HistoryViewModelFactory(activity?.application as MainApp)).get(
            HistoryViewModel::class.java)


    }
}