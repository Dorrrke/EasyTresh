package com.example.easytresh.presentation.client_screens

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.clientViewModels.ProfileViewModel
import com.example.easytresh.domain.ViewModelFactories.ProfileViewModelFactory


class ProfileFragment : Fragment(R.layout.fragment_profile) {


    lateinit var viewModel: ProfileViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(this, ProfileViewModelFactory(activity?.application as MainApp)).get(
                ProfileViewModel::class.java
            )
//        generalViewModel = ViewModelProvider(this, AllFragmentsViewModelFactory(activity?.application as MainApp)).get(
//            AllFragmentsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var client = viewModel.getClient(MainFragment.userId)
        view.findViewById<TextView>(R.id.nameView).text = client.userName
        view.findViewById<TextView>(R.id.phoneView).text = client.userPhone
        view.findViewById<TextView>(R.id.dateView).text = client.registrationDate
    }
}
