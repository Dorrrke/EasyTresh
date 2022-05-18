package com.example.easytresh.repository

import androidx.lifecycle.LiveData
import com.example.easytresh.repository.database.AppDatabase
import com.example.easytresh.repository.database.entity.Addresses
import com.example.easytresh.repository.database.entity.Orders
import com.example.easytresh.repository.database.entity.Users
import io.reactivex.Single

class AppRepository(private val database: AppDatabase) {

    fun insertUser(user: Users) {
        database.UsersDao().insert(user)
    }

    fun getUserByNumber(phone: String): Users {
        return database.UsersDao().getUserByPhone(phone)
    }

    fun getUserById(id: Int): Users {
        return database.UsersDao().getUserById(id)
    }

    fun getAll(): List<Users> {
        return database.UsersDao().getAllUsers()
    }

    fun insertAddress(adr: Addresses) {
        database.AddressesDao().insert(adr)
    }

    fun getAddressByUserId(uId: Int): LiveData<List<Addresses>> {
        return database.AddressesDao().getClientAddresses(uId)
    }

    fun getAddressByInfo(id: Int, string: String, number: Int): Addresses {
        return database.AddressesDao().getClientAddress(id, string, number)
    }

    fun getAddressById(id: Int): Addresses{
        return database.AddressesDao().getAddressesById(id)
    }

    fun insertOrder(order: Orders) {
        database.OrdersDao().insert(order)
    }

    fun getAllOrders(): LiveData<List<Orders>> {
        return database.OrdersDao().getAllOrders()
    }
}