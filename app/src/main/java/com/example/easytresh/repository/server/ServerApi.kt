package com.example.easytresh.repository.server

import com.example.easytresh.repository.database.entity.Orders
import com.example.easytresh.repository.database.entity.Users
import com.example.easytresh.repository.database.pojo.AddressesPojoItem
import com.example.easytresh.repository.database.pojo.ClientPojoItem
import com.example.easytresh.repository.database.pojo.OrdersPojo
import com.example.easytresh.repository.database.pojo.OrdersPojoItem
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServerApi {
    @POST("/getOrdersByUserId")
    fun getOrdersByUserId(@Body id: Int): Single<List<OrdersPojoItem>>

    @POST("/createClient")
    fun createClient(@Body client: Users) : Single<String>

    @POST("/getUser")
    fun getClient(@Body clientPojoItem: ClientPojoItem) : Single<ClientPojoItem>

    @POST("/getUserById")
    fun getClientById(@Body id: Int) : Single<ClientPojoItem>

    @POST("/checkClient")
    fun checkClient(@Body clientPojoItem: ClientPojoItem): Single<String>

    @POST("/addOrder")
    fun addOrder(@Body ordersPojoItem: OrdersPojoItem) : Single<String>

    @POST("/addAddress")
    fun addAddress(@Body addressesPojoItem: AddressesPojoItem) : Single<String>

    @POST("/getAddressesByClientId")
    fun getAddressesByClientId(@Body id: Int) : Single<List<AddressesPojoItem>>

    @POST("/getAddressesById")
    fun getAddressesById(@Body id: Int): Single<AddressesPojoItem>
}