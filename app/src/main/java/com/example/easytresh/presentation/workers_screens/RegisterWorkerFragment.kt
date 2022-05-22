package com.example.easytresh.presentation.workers_screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.ViewModelFactories.RegisterViewModelFactory
import com.example.easytresh.domain.ViewModelFactories.RegisterWorkerViewModelFactory
import com.example.easytresh.domain.clientViewModels.RegisterViewModel
import com.example.easytresh.domain.workersViewModles.RegisterWorkerViewModel

class RegisterWorkerFragment: Fragment(R.layout.fragment_worker_register) {

    lateinit var viewModel: RegisterWorkerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, RegisterWorkerViewModelFactory(activity?.application as MainApp)).get(
            RegisterWorkerViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val singBtn = view.findViewById<Button>(R.id.singBtn)
        singBtn.setOnClickListener {
            val res = viewModel.correctValue(
                view.findViewById<EditText>(R.id.singUpFullName).text.toString(),
                view.findViewById<EditText>(R.id.singUpPhone).text.toString(),
                view.findViewById<EditText>(R.id.singUpPassword).text.toString(),
                view.findViewById<EditText>(R.id.singUpRepeatPassword).text.toString())

            if (res)
            {
                findNavController().navigate(R.id.action_registerWorkerFragment_to_loginWorkerFragment)
            }
            else {
                val toast = Toast.makeText(context, "Error", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }
}