package com.example.easytresh.repository.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.easytresh.repository.database.entity.Addresses
import com.example.easytresh.repository.database.entity.Orders


@Dao
interface AddressesDao {
    @Query("SELECT * FROM Addresses")
    fun getAllAddresses(): LiveData<List<Addresses>>

    @Query("SELECT * FROM Addresses WHERE ClientId=:id")
    fun getClientAddresses(id: Int): LiveData<List<Addresses>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(addresses: Addresses)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(addresses: Addresses)

    @Delete
    fun delete(addresses: Addresses)
}