package com.example.easytresh.presentation.client_screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.LoginViewModel
import com.example.easytresh.domain.RegisterViewModel
import javax.inject.Inject

class LoginFragment : Fragment(R.layout.fragment_login) {

    @Inject
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as MainApp).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val singInBtn = view.findViewById<Button>(R.id.loginBtn)
        val singUpBtn = view.findViewById<Button>(R.id.registerBtn)


        singInBtn.setOnClickListener {
            val phone = view.findViewById<EditText>(R.id.editTextPhone).text.toString()
            val pass = view.findViewById<EditText>(R.id.editTextPass).text.toString()
            val res = viewModel.verf(phone, pass)
            if (res)
            {
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
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
}