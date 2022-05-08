package com.example.easytresh.presentation.client_screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.HistoryViewModel
import javax.inject.Inject

class HistoryFragment() : Fragment(R.layout.fragment_history) {

    @Inject
    lateinit var viewModel: HistoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as MainApp).appComponent.inject(this)


    }
}