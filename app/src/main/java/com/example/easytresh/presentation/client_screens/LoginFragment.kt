package com.example.easytresh.presentation.client_screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.clientViewModels.LoginViewModel
import com.example.easytresh.domain.ViewModelFactories.LoginViewModelFactory
import com.example.easytresh.repository.database.pojo.ClientPojoItem

class LoginFragment : Fragment(R.layout.fragment_login) {


    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, LoginViewModelFactory(activity?.application as MainApp)).get(
            LoginViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val singInBtn = view.findViewById<Button>(R.id.loginBtn)
        val singUpBtn = view.findViewById<Button>(R.id.registerBtn)

        singInBtn.setOnClickListener {
            val phone = view.findViewById<EditText>(R.id.editTextPhone).text.toString()
            val pass = view.findViewById<EditText>(R.id.editTextPass).text.toString()
            if (phone.isNotEmpty() and pass.isNotEmpty())
            {
                viewModel.verification(phone, pass)
                viewModel.resultVerification().observe(viewLifecycleOwner, Observer { checkResult(it, phone) })
            }
            else
            {
                val toast = Toast.makeText(context, "Error", Toast.LENGTH_SHORT)
                toast.show()
            }
        }

        singUpBtn.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun checkResult(it: Boolean?, phone: String) {
        if (it == true){
            viewModel.catchClient(phone)
            viewModel.getClient().observe(viewLifecycleOwner, Observer {  findNavController().navigate(R.id.action_loginFragment_to_mainFragment,
                bundleOf(MainFragment.userIdKey to it.userId)) })
        }
        else{
            val toast = Toast.makeText(context, "No Success.This phone number is already registered", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

//    private fun loggingUser(it: ClientPojoItem?) {
//        if (it != null) {
//            findNavController().navigate(R.id.action_loginFragment_to_mainFragment,
//                bundleOf(MainFragment.userIdKey to it.userId))
//        }
//    }
}

