package com.example.easytresh.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.repository.AppRepository
import com.example.easytresh.repository.database.entity.Orders
import com.example.easytresh.repository.database.pojo.OrdersPojo
import com.example.easytresh.repository.database.pojo.OrdersPojoItem
import javax.inject.Inject

class OrdersAdapter(private val orders: List<OrdersPojoItem>, application: MainApp): RecyclerView.Adapter<OrdersAdapter.OrderViewHolder>(){

    @Inject
    lateinit var repository: AppRepository
    init {
        (application as MainApp).appComponent.inject(this)
    }
    class OrderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var dataText: TextView? = null
        var typeText: TextView? = null
        var sizeText: TextView? = null
        init {
            dataText = itemView.findViewById(R.id.dataText)
            typeText = itemView.findViewById(R.id.trashTypeText)
            sizeText = itemView.findViewById(R.id.sizeText)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.order_items, parent, false)
        return OrderViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        var addr = orders[position].addressId
        holder.dataText!!.text = orders[position].date
        holder.typeText!!.text = orders[position].trashType
        holder.sizeText!!.text = orders[position].size
    }

    override fun getItemCount(): Int = orders.size
}