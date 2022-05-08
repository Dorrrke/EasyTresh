package com.example.easytresh.presentation.client_screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.RegisterViewModel
import javax.inject.Inject


class RegisterFragment : Fragment(R.layout.fragment_register) {

    @Inject
    lateinit var viewModel: RegisterViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as MainApp).appComponent.inject(this)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val singUpBtn = view.findViewById<Button>(R.id.singUpBtn)
        singUpBtn.setOnClickListener {
            val res = viewModel.correctValue(
                view.findViewById<EditText>(R.id.singUpFullName).text.toString(),
                view.findViewById<EditText>(R.id.singUpPhone).text.toString(),
                view.findViewById<EditText>(R.id.singUpPassword).text.toString(),
                view.findViewById<EditText>(R.id.singUpRepeatPassword).text.toString())

            if (res)
            {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
            else {
                val toast = Toast.makeText(context, "Error", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }

}