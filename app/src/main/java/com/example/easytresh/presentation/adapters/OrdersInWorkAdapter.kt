package com.example.easytresh.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.presentation.workers_screens.OrderDetailFragment
import com.example.easytresh.repository.database.pojo.NotRelevantOrdersPojoItem
import com.example.easytresh.repository.database.pojo.OrdersPojoItem

class OrdersInWorkAdapter(
    private val orders: List<NotRelevantOrdersPojoItem>,
    application: MainApp,
    navController: NavController
) : RecyclerView.Adapter<OrdersInWorkAdapter.OrdersInWorkAdapterViewHolder>() {
    var navController = navController

    class OrdersInWorkAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var dataText: TextView? = null
        var typeText: TextView? = null
        var sizeText: TextView? = null
        var relevantText: TextView? = null
        var layout: LinearLayout? = null

        init {
            dataText = itemView.findViewById(R.id.orderDataField)
            relevantText = itemView.findViewById(R.id.orderRelevanceField)
            typeText = itemView.findViewById(R.id.orderTrashTypeField)
            sizeText = itemView.findViewById(R.id.orderSizeField)
            layout = itemView.findViewById(R.id.listLayout)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrdersInWorkAdapterViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.order_list_items, parent, false)
        return OrdersInWorkAdapterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OrdersInWorkAdapterViewHolder, position: Int) {
        holder.dataText!!.text = orders[position]!!.date
        holder.typeText!!.text = orders[position]!!.trashType
        holder.sizeText!!.text = orders[position]!!.size
        holder.relevantText!!.text = orders[position]!!.relevance.toString()
        holder.layout!!.setOnClickListener {}
    }

    override fun getItemCount(): Int = orders.size

}