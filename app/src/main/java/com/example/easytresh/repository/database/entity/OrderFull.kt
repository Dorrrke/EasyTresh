package com.example.easytresh.repository.database.entity

import com.example.easytresh.repository.database.pojo.AddressesPojoItem
import com.google.gson.annotations.SerializedName

data class OrderFull(
    @field:SerializedName("date")
    var date: String? = null,

    @field:SerializedName("trashType")
    val trashType: String? = null,

    @field:SerializedName("clientId")
    val clientId: Int? = null,

    @field:SerializedName("size")
    val size: String? = null,

    @field:SerializedName("orderId")
    val orderId: Int? = null,

    @field:SerializedName("relevance")
    val relevance: Boolean? = null,

    @field:SerializedName("addressId")
    val address: AddressesPojoItem? = null
)