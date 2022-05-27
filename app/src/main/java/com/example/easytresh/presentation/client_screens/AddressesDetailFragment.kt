package com.example.easytresh.presentation.client_screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.ViewModelFactories.DetailViewModelFactory
import com.example.easytresh.domain.clientViewModels.DetailViewModel
import com.example.easytresh.presentation.adapters.AddressesAdapter
import com.example.easytresh.repository.database.pojo.AddressesPojoItem

class AddressesDetailFragment : Fragment(R.layout.fragment_address_detail) {

    lateinit var addressesList : RecyclerView

    lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(this, DetailViewModelFactory(activity?.application as MainApp)).get(
                DetailViewModel::class.java
            )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addressesList = view.findViewById<RecyclerView>(R.id.addressesView)
        view.findViewById<Button>(R.id.addressBtn).setOnClickListener {
            findNavController().navigate(R.id.action_addressesListFragment_to_addAddressFragment)
        }
        viewModel.getAddressesList(MainFragment.userId)
        viewModel.getAddresses().observe(viewLifecycleOwner, Observer { initRecyclerView(it) })

        view.findViewById<Button>(R.id.choseBtn).setOnClickListener {
            if (viewModel.addressId != null)
            {
                findNavController().navigate(R.id.action_addressesListFragment_to_orderFragment, bundleOf(OrderFragment.addressId to viewModel.addressId))
            }
        }
    }


    private fun initRecyclerView(it: List<AddressesPojoItem>?) {
        val addressAdapter = AddressesAdapter(it!!, activity?.application as MainApp, viewModel)
        addressesList.layoutManager = LinearLayoutManager(context)
        addressesList.adapter = addressAdapter
    }
}