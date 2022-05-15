package com.example.easytresh.presentation.client_screens

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.AllFragmentsViewModel
import com.example.easytresh.domain.ProfileViewModel
import com.example.easytresh.domain.ViewModelFactories.AllFragmentsViewModelFactory
import com.example.easytresh.domain.ViewModelFactories.ProfileViewModelFactory


class ProfileFragment : Fragment(R.layout.fragment_profile) {


    lateinit var viewModel: ProfileViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, ProfileViewModelFactory(activity?.application as MainApp)).get(
            ProfileViewModel::class.java)
//        generalViewModel = ViewModelProvider(this, AllFragmentsViewModelFactory(activity?.application as MainApp)).get(
//            AllFragmentsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var id = MainFragment.userId
        var text = view?.findViewById<TextView>(R.id.editTextTextPersonName)
        if (text != null) {
            text.text = id.toString()
        }
    }
}
