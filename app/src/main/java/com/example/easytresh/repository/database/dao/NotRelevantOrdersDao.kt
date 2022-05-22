package com.example.easytresh.repository.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.easytresh.repository.database.entity.NotRelevantOrders
import com.example.easytresh.repository.database.entity.Orders

@Dao
interface NotRelevantOrdersDao {
    @Query("SELECT * FROM NotRelevantOrders")
    fun getAllOrders(): LiveData<List<NotRelevantOrders>>

    @Query("SELECT * FROM NotRelevantOrders WHERE OrderId=:id")
    fun getOrderById(id: Int): NotRelevantOrders

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(order: NotRelevantOrders)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(order: NotRelevantOrders)

    @Delete
    fun delete(order: NotRelevantOrders)
}