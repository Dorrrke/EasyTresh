package com.example.easytresh.repository.server

import com.example.easytresh.repository.database.entity.Orders
import com.example.easytresh.repository.database.entity.Users
import com.example.easytresh.repository.database.pojo.*
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServerApi {

    //// Users

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

    ////Workers

    @POST("/createWorker")
    fun createWorker(@Body workersPojoItem: WorkersPojoItem) : Single<String>

    @POST("/checkWorker")
    fun checkWorker(@Body workersPojoItem: WorkersPojoItem) : Single<String>

    @POST("/getWorkerById")
    fun getWorkerById(@Body id: Int) : Single<WorkersPojoItem>

    @POST("/getWorker")
    fun getWorker(@Body workersPojoItem: WorkersPojoItem) : Single<WorkersPojoItem>

    ////Orders

    @POST("/addOrder")
    fun addOrder(@Body ordersPojoItem: OrdersPojoItem) : Single<String>

    @GET("/allRelevantOrders")
    fun allRelevantOrders() : Single<List<OrdersPojoItem>>

    @POST("/getOrdersById")
    fun getOrderById(@Body id: Int) : Single<OrdersPojoItem>

    @POST("/deleteOrder")
    fun deleteOrder(@Body id: Int) : Single<String>

    @POST("/updateNOrder")
    fun updateNOrder(@Body id: Int): Single<String>

    @POST("/addNotRelevantOrder")
    fun addNOrder(@Body notRelevantOrdersPojoItem: NotRelevantOrdersPojoItem) : Single<String>

    @POST("/getOrdersByWorkerId")
    fun getNOrderByWorkerId(@Body id: Int): Single<List<NotRelevantOrdersPojoItem>>

    @POST("/getOldOrdersByWorkerId")
    fun getOldOrdersByWorkerId(@Body id: Int): Single<List<NotRelevantOrdersPojoItem>>

    @POST("/getNOrdersById")
    fun getNOrderById(@Body id: Int): Single<NotRelevantOrdersPojoItem>

    @POST("/getNOrdersByUserId")
    fun getNOrdersByUserId(@Body id: Int): Single<List<NotRelevantOrdersPojoItem>>


    ////Addresses

    @POST("/addAddress")
    fun addAddress(@Body addressesPojoItem: AddressesPojoItem) : Single<String>

    @POST("/getAddressesByClientId")
    fun getAddressesByClientId(@Body id: Int) : Single<List<AddressesPojoItem>>

    @POST("/getAddressesById")
    fun getAddressesById(@Body id: Int): Single<AddressesPojoItem>
}