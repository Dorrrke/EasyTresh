package com.example.easytresh.presentation.workers_screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.ViewModelFactories.RegisterWorkerViewModelFactory
import com.example.easytresh.domain.workersViewModles.RegisterWorkerViewModel

class RegisterWorkerFragment : Fragment(R.layout.fragment_worker_register) {

    lateinit var viewModel: RegisterWorkerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            RegisterWorkerViewModelFactory(activity?.application as MainApp)
        ).get(
            RegisterWorkerViewModel::class.java
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val singBtn = view.findViewById<Button>(R.id.singBtn)
        singBtn.setOnClickListener {
            if (viewModel.checkWorkerFields(
                    view.findViewById<EditText>(R.id.singFullName).text.toString(),
                    view.findViewById<EditText>(R.id.singPhone).text.toString(),
                    view.findViewById<EditText>(R.id.singPassword).text.toString(),
                    view.findViewById<EditText>(R.id.singRepeatPassword).text.toString()
                )
            ) {
                viewModel.addWorker(
                    view.findViewById<EditText>(R.id.singFullName).text.toString(),
                    view.findViewById<EditText>(R.id.singPhone).text.toString(),
                    view.findViewById<EditText>(R.id.singPassword).text.toString()
                )
                viewModel.addingWorkerResult()
                    .observe(viewLifecycleOwner, Observer { checkResult(it) })
                findNavController().navigate(R.id.action_registerWorkerFragment_to_loginWorkerFragment)
            } else {
                val toast = Toast.makeText(context, " No Success ", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }

    private fun checkResult(it: Boolean?) {
        if (it == true) {
            val toast = Toast.makeText(context, " Success ", Toast.LENGTH_SHORT)
            toast.show()
        } else {
            val toast = Toast.makeText(
                context,
                "No Success.This phone number is already registered",
                Toast.LENGTH_SHORT
            )
            toast.show()
        }
    }
}