package com.example.easytresh.presentation.client_screens

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.HistoryViewModel
import com.example.easytresh.domain.OrderViewModel
import com.example.easytresh.domain.ViewModelFactories.HistoryViewModelFactory
import com.example.easytresh.domain.ViewModelFactories.OrderViewModelFactory
import com.example.easytresh.repository.database.entity.Addresses
import com.example.easytresh.repository.database.entity.Orders
import javax.inject.Inject

class OrderFragment : Fragment(R.layout.fragment_order) {


    lateinit var viewModel: OrderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(this, OrderViewModelFactory(activity?.application as MainApp)).get(
                OrderViewModel::class.java
            )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var typeBuildingCheckBox = view.findViewById<CheckBox>(R.id.buildingCheckBox)
        var typeDomesticCheckBox = view.findViewById<CheckBox>(R.id.domesticCheckBox)
        var editSize = view.findViewById<EditText>(R.id.editSize)
        var editCountry = view.findViewById<EditText>(R.id.editCountry)
        var editCity = view.findViewById<EditText>(R.id.editCity)
        var editStreet = view.findViewById<EditText>(R.id.editStreet)
        var editHouseNumber = view.findViewById<EditText>(R.id.editHouse)
        var editFrame = view.findViewById<EditText>(R.id.editFrame)
        var editDoor = view.findViewById<EditText>(R.id.editDoor)
        var editFloor = view.findViewById<EditText>(R.id.editFloor)
        var editFlat = view.findViewById<EditText>(R.id.editFlat)
        var saveCheck = view.findViewById<CheckBox>(R.id.saveAdrCheckBox)
        var orderBtn = view.findViewById<Button>(R.id.orderBtn)

        orderBtn.setOnClickListener {
            if (editSize.text.isNotEmpty() and editCountry.text.isNotEmpty()
                and editCity.text.isNotEmpty() and editStreet.text.isNotEmpty()
                and editHouseNumber.text.isNotEmpty() and editFrame.text.isNotEmpty()
                and editDoor.text.isNotEmpty() and editFloor.text.isNotEmpty()
                and editFlat.text.isNotEmpty()
            ) {
                if ((typeBuildingCheckBox.isChecked and typeDomesticCheckBox.isChecked) or (!typeBuildingCheckBox.isChecked and !typeDomesticCheckBox.isChecked)) {
                    val toast =
                        Toast.makeText(context, "Выберете один из типов мусора", Toast.LENGTH_SHORT)
                    toast.show()
                } else {
                    if (typeDomesticCheckBox.isChecked) {
                        viewModel.setUpOrder(
                            Addresses(
                                0,
                                editCountry.text.toString(),
                                editCity.text.toString(),
                                editStreet.text.toString(),
                                editHouseNumber.text.toString().toInt(),
                                editFrame.text.toString().toInt(),
                                editDoor.text.toString().toInt(),
                                editFloor.text.toString().toInt(),
                                editFlat.text.toString().toInt(),
                                MainFragment.userId
                            ),
                            Orders(0, "", "Domestic", editSize.text.toString(),0, MainFragment.userId)
                        )
                    }
                    else{
                        viewModel.setUpOrder(
                            Addresses(
                                0,
                                editCountry.text.toString(),
                                editCity.text.toString(),
                                editStreet.text.toString(),
                                editHouseNumber.text.toString().toInt(),
                                editFrame.text.toString().toInt(),
                                editDoor.text.toString().toInt(),
                                editFloor.text.toString().toInt(),
                                editFlat.text.toString().toInt(),
                                MainFragment.userId
                            ),
                            Orders(0, "", "Building", editSize.text.toString(), 0, MainFragment.userId)
                        )
                    }
                }
            }
            else{
                val toast =
                    Toast.makeText(context, "Заполните поля", Toast.LENGTH_SHORT)
                toast.show()
            }
        }


    }
}