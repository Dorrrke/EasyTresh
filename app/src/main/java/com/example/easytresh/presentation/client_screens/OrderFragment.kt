package com.example.easytresh.presentation.client_screens

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.clientViewModels.OrderViewModel
import com.example.easytresh.domain.ViewModelFactories.OrderViewModelFactory
import com.example.easytresh.repository.database.entity.Orders
import com.example.easytresh.repository.database.pojo.AddressesPojoItem
import com.example.easytresh.repository.database.pojo.OrdersPojoItem

class OrderFragment : Fragment(R.layout.fragment_order) {


    lateinit var viewModel: OrderViewModel


    var address = AddressesPojoItem()

    companion object {
        const val addressId = "ADDRESS_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(this, OrderViewModelFactory(activity?.application as MainApp)).get(
                OrderViewModel::class.java
            )
        if (arguments != null) {
            viewModel.setAddrId(arguments?.get(addressId) as Int)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var typeBuildingCheckBox = view.findViewById<CheckBox>(R.id.buildingCheckBox)
        var typeDomesticCheckBox = view.findViewById<CheckBox>(R.id.domesticCheckBox)
        var editSize = view.findViewById<EditText>(R.id.editSize)
        var orderBtn = view.findViewById<Button>(R.id.orderBtn)
        if (viewModel.adrrId != -1) {
            viewModel.getAddressById()
            viewModel.getAddress().observe(viewLifecycleOwner, Observer { initAddressField(it) })
        }
        view.findViewById<Button>(R.id.choseAddressBtn).setOnClickListener {
            findNavController().navigate(R.id.action_orderFragment_to_addressesListFragment)
        }

        orderBtn.setOnClickListener {
            if (editSize.text.isNotEmpty()) {
                if ((typeBuildingCheckBox.isChecked and typeDomesticCheckBox.isChecked) or (!typeBuildingCheckBox.isChecked and !typeDomesticCheckBox.isChecked)) {
                    val toast =
                        Toast.makeText(context, "Выберете один из типов мусора", Toast.LENGTH_SHORT)
                    toast.show()
                } else {
                    if (typeDomesticCheckBox.isChecked) {
                        viewModel.setUpOrder(
                            address,
                            OrdersPojoItem(
                                null,
                                "Domestic",
                                MainFragment.userId,
                                editSize.text.toString(),
                                null,
                                true,
                                address.id
                            )
                        )
                        viewModel.getResultAdding()
                            .observe(viewLifecycleOwner, Observer { checkResult(it) })
                    } else {
                        viewModel.setUpOrder(
                            address,
                            OrdersPojoItem(
                                null,
                                "Building",
                                MainFragment.userId,
                                editSize.text.toString(),
                                null,
                                true,
                                address.id
                            )
                        )
                        viewModel.getResultAdding()
                            .observe(viewLifecycleOwner, Observer { checkResult(it) })
                    }
                }
            } else {
                val toast =
                    Toast.makeText(context, "Заполните поля", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }

    private fun checkResult(it: String?) {
        val toast =
            Toast.makeText(context, "Результат оформления заказа $it", Toast.LENGTH_SHORT)
        toast.show()
    }

    private fun initAddressField(it: AddressesPojoItem) {
        address = it
        view?.findViewById<TextView>(R.id.cityAd)?.text = it.city
        view?.findViewById<TextView>(R.id.streetAd)?.text = it.street
        view?.findViewById<TextView>(R.id.houseAd)?.text = it.houseNumber.toString()
        view?.findViewById<TextView>(R.id.frameAd)?.text = it.frame.toString()
        view?.findViewById<TextView>(R.id.doorAd)?.text = it.frontDoor.toString()
        view?.findViewById<TextView>(R.id.floorAd)?.text = it.floor.toString()
        view?.findViewById<TextView>(R.id.flatAd)?.text = it.flat.toString()
    }
}