package com.example.easytresh.presentation.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.clientViewModels.DetailViewModel
import com.example.easytresh.domain.clientViewModels.OrderViewModel
import com.example.easytresh.repository.AppRepository
import com.example.easytresh.repository.database.pojo.AddressesPojoItem
import com.example.easytresh.repository.database.pojo.OrdersPojoItem
import javax.inject.Inject

class AddressesAdapter(
    private val addresses: List<AddressesPojoItem>,
    application: MainApp,
    viewModel: DetailViewModel, ): RecyclerView.Adapter<AddressesAdapter.AddressesViewHolder>() {

    var app = application
    var viewModel = viewModel

    class AddressesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cityText: TextView? = null
        var street: TextView? = null
        var house: TextView? = null
        var frame: TextView? = null
        var door: TextView? = null
        var floor: TextView? = null
        var flat: TextView? = null
        var layout: LinearLayout? = null
        init {
            cityText = itemView.findViewById(R.id.cityTextAd)
            street = itemView.findViewById(R.id.streetTextAd)
            house = itemView.findViewById(R.id.houseTextAd)
            frame = itemView.findViewById(R.id.frameTextAd)
            door = itemView.findViewById(R.id.doorTextAd)
            floor = itemView.findViewById(R.id.floorTextAd)
            flat = itemView.findViewById(R.id.flatTextAd)
            layout = itemView.findViewById(R.id.layoutId)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AddressesAdapter.AddressesViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.address_item, parent, false)
        return AddressesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AddressesAdapter.AddressesViewHolder, position: Int) {
        holder.cityText!!.text = addresses[position].city
        holder.street!!.text = addresses[position].street
        holder.house!!.text = addresses[position].houseNumber.toString()
        holder.frame!!.text = addresses[position].frame.toString()
        holder.door!!.text = addresses[position].frontDoor.toString()
        holder.floor!!.text = addresses[position].floor.toString()
        holder.flat!!.text = addresses[position].flat.toString()
        holder.layout!!.setOnClickListener {
            if (viewModel.addressId == -1)
            {
                viewModel.choseAddress(addresses[position].id!!)
            }
            else
            {
                val toast = Toast.makeText(app, "Вы уже выбрали аддресс", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }

    override fun getItemCount(): Int = addresses.size
}

