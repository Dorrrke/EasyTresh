package com.example.easytresh.presentation.client_screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.clientViewModels.RegisterViewModel
import com.example.easytresh.domain.ViewModelFactories.RegisterViewModelFactory
import kotlin.properties.Delegates


class RegisterFragment : Fragment(R.layout.fragment_register) {


    lateinit var viewModel: RegisterViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, RegisterViewModelFactory(activity?.application as MainApp)).get(
            RegisterViewModel::class.java)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val singUpBtn = view.findViewById<Button>(R.id.singUpBtn)
        singUpBtn.setOnClickListener {
            if(viewModel.checkClientFields(
                view.findViewById<EditText>(R.id.singUpFullName).text.toString(),
                view.findViewById<EditText>(R.id.singUpPhone).text.toString(),
                view.findViewById<EditText>(R.id.singUpPassword).text.toString(),
                view.findViewById<EditText>(R.id.singUpRepeatPassword).text.toString())){
                viewModel.addClient(view.findViewById<EditText>(R.id.singUpFullName).text.toString(),
                    view.findViewById<EditText>(R.id.singUpPhone).text.toString(),
                    view.findViewById<EditText>(R.id.singUpPassword).text.toString())
                viewModel.addingClientResult().observe(viewLifecycleOwner, Observer { checkResult(it)
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)})
            }
            else{
                val toast = Toast.makeText(context, " No Success ", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }

    private fun checkResult(it: Boolean?) {
        if (it == true){
            val toast = Toast.makeText(context, " Success ", Toast.LENGTH_SHORT)
            toast.show()
        }
        else{
            val toast = Toast.makeText(context, "No Success.This phone number is already registered", Toast.LENGTH_SHORT)
            toast.show()
        }
    }


}