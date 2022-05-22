package com.example.easytresh.presentation.workers_screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.ViewModelFactories.LoginViewModelFactory
import com.example.easytresh.domain.ViewModelFactories.LoginWorkerViewModelFactory
import com.example.easytresh.domain.clientViewModels.LoginViewModel
import com.example.easytresh.domain.workersViewModles.LoginWorkerViewModel
import com.example.easytresh.presentation.client_screens.MainFragment

class LoginWorkerFragment: Fragment(R.layout.fragment_worker_login) {


    lateinit var viewModel: LoginWorkerViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, LoginWorkerViewModelFactory(activity?.application as MainApp)).get(
            LoginWorkerViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val singInBtn = view.findViewById<Button>(R.id.workerSingInBtn)
        val singUpBtn = view.findViewById<Button>(R.id.workerSignUpBtn)

        singInBtn.setOnClickListener {
            val phone = view.findViewById<EditText>(R.id.Phone).text.toString()
            val pass = view.findViewById<EditText>(R.id.Pass).text.toString()
            val res = viewModel.verf(phone, pass)
            if (res != null)
            {
                findNavController().navigate(R.id.action_loginWorkerFragment_to_mainWorkerFragment,
                    bundleOf(MainFragment.userIdKey to res.UserId)
                )
            }
            else
            {
                val toast = Toast.makeText(context, "Error", Toast.LENGTH_SHORT)
                toast.show()
            }
}
        singUpBtn.setOnClickListener {
            findNavController().navigate(R.id.action_loginWorkerFragment_to_registerWorkerFragment)
        }
    }
}