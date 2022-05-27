package com.example.easytresh.repository.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    foreignKeys = [ForeignKey(
        entity = Users::class,
        parentColumns = arrayOf("UserId"),
        childColumns = arrayOf("ClientId"),
        onDelete = CASCADE
    ),
        ForeignKey(
            entity = Addresses::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("AddressId"),
            onDelete = CASCADE
        )]
)
data class Orders(

    @field:SerializedName("orderId")
    @PrimaryKey(autoGenerate = true) val OrderId: Int,

    @field:SerializedName("date")
    @ColumnInfo(name = "Date") val date: String,

    @field:SerializedName("trashType")
    @ColumnInfo(name = "TrashType") val type: String,

    @field:SerializedName("size")
    @ColumnInfo(name = "Size") val size: String,

    @field:SerializedName("addressId")
    @ColumnInfo(name = "AddressId") val addressId: Int,

    @field:SerializedName("relevance")
    @ColumnInfo(name = "Relevance") val relevance: Boolean,

    @field:SerializedName("clientId")
    @ColumnInfo(name = "ClientId") val clientId: Int
)
