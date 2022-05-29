package com.example.easytresh.presentation.client_screens

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.clientViewModels.ProfileViewModel
import com.example.easytresh.domain.ViewModelFactories.ProfileViewModelFactory
import com.example.easytresh.repository.database.pojo.ClientPojoItem


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
        viewModel.catchClient(MainFragment.userId)
        viewModel.getClient().observe(viewLifecycleOwner, Observer { fillFields(it) })
    }

    private fun fillFields(it: ClientPojoItem?) {
        if (it != null) {
            view?.findViewById<TextView>(R.id.nameField)!!.text = it.name
            view?.findViewById<TextView>(R.id.phoneField)!!.text = it.phone
            view?.findViewById<TextView>(R.id.dateField)!!.text = it.registrationDate
        }
    }
}
