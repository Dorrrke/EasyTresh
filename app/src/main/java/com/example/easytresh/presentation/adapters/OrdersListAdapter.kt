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
import com.example.easytresh.repository.database.pojo.OrdersPojo
import com.example.easytresh.repository.database.pojo.OrdersPojoItem

class OrdersListAdapter(
    private val orders: List<OrdersPojoItem>,
    application: MainApp,
    navController: NavController
): RecyclerView.Adapter<OrdersListAdapter.OrdersListViewHolder>() {
    var navController = navController
    class OrdersListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersListViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.order_list_items, parent, false)
        return OrdersListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OrdersListViewHolder, position: Int) {
        holder.dataText!!.text = orders[position]!!.date
        holder.typeText!!.text = orders[position]!!.trashType
        holder.sizeText!!.text = orders[position]!!.size
        holder.relevantText!!.text = orders[position]!!.relevance.toString()
        holder.layout!!.setOnClickListener {
            navController.navigate(R.id.action_workersOrdersList_to_orderDetailFragment, bundleOf(OrderDetailFragment.orderKey to orders[position].orderId))
        }
    }

    override fun getItemCount(): Int = orders.size

}
