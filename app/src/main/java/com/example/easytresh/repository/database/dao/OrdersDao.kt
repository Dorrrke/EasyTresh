package com.example.easytresh.repository.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.easytresh.repository.database.entity.Orders
import com.example.easytresh.repository.database.entity.Users

@Dao
interface OrdersDao {
    @Query("SELECT * FROM Orders")
    fun getAllOrders(): LiveData<List<Orders>>

    @Query("SELECT * FROM Orders WHERE Relevance=1")
    fun getRelevanceOrders(): LiveData<List<Orders>>

    @Query("SELECT * FROM Orders WHERE OrderId=:id")
    fun getOrderById(id: Int): Orders

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(order: Orders)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(order: Orders)

    @Delete
    fun delete(order: Orders)
}