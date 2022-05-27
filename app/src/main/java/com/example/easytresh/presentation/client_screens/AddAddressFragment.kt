package com.example.easytresh.presentation.client_screens

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
import com.example.easytresh.domain.ViewModelFactories.AddAddressViewModelFactory
import com.example.easytresh.domain.ViewModelFactories.DetailViewModelFactory
import com.example.easytresh.domain.clientViewModels.AddAddressViewModel
import com.example.easytresh.domain.clientViewModels.DetailViewModel
import com.example.easytresh.repository.database.pojo.AddressesPojoItem

class AddAddressFragment : Fragment(R.layout.fragment_add_address) {

    lateinit var viewModel: AddAddressViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(
                this,
                AddAddressViewModelFactory(activity?.application as MainApp)
            ).get(
                AddAddressViewModel::class.java
            )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.saveAddrBtn).setOnClickListener {
            if (view.findViewById<EditText>(R.id.addCountry).text.isNotEmpty() and
                view.findViewById<EditText>(R.id.addDoor).text.isNotEmpty() and
                view.findViewById<EditText>(R.id.addCity).text.isNotEmpty() and
                view.findViewById<EditText>(R.id.addStreet).text.isNotEmpty() and
                view.findViewById<EditText>(R.id.addFlat).text.isNotEmpty() and
                view.findViewById<EditText>(R.id.addHouse).text.isNotEmpty() and
                view.findViewById<EditText>(R.id.addFloor).text.isNotEmpty() and
                view.findViewById<EditText>(R.id.addFrame).text.isNotEmpty())
            {
                viewModel.addAddress(
                    AddressesPojoItem(
                        view.findViewById<EditText>(R.id.addCountry).text.toString(),
                        view.findViewById<EditText>(R.id.addDoor).text.toString().toInt(),
                        MainFragment.userId,
                        view.findViewById<EditText>(R.id.addCity).text.toString(),
                        view.findViewById<EditText>(R.id.addStreet).text.toString(),
                        view.findViewById<EditText>(R.id.addFlat).text.toString().toString().toInt(),
                        view.findViewById<EditText>(R.id.addHouse).text.toString().toInt(),
                        null,
                        view.findViewById<EditText>(R.id.addFloor).text.toString().toInt(),
                        view.findViewById<EditText>(R.id.addFrame).text.toString().toInt()
                    )
                )
                viewModel.getResult().observe(viewLifecycleOwner, Observer { checkResult(it) })
                findNavController().navigate(R.id.action_addAddressFragment_to_addressesListFragment)
            }
            else {
                val toast = Toast.makeText(context, "Запоните поля!", Toast.LENGTH_SHORT)
                toast.show()
            }

        }

    }

    private fun checkResult(it: String?) {
        if (it.toBoolean()) {
            val toast = Toast.makeText(context, " Success ", Toast.LENGTH_SHORT)
            toast.show()
        } else {
            val toast = Toast.makeText(context, "No Success", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

}

