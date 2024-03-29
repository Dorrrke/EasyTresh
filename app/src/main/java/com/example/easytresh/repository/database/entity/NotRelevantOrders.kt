package com.example.easytresh.repository.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    foreignKeys = [ForeignKey(
        entity = Users::class,
        parentColumns = arrayOf("UserId"),
        childColumns = arrayOf("ClientId"),
        onDelete = ForeignKey.CASCADE
    ),
        ForeignKey(
            entity = Addresses::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("AddressId"),
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Workers::class,
            parentColumns = arrayOf("WorkerId"),
            childColumns = arrayOf("WorkerId"),
            onDelete = ForeignKey.CASCADE
        )]
)
data class NotRelevantOrders(
    @PrimaryKey(autoGenerate = true) val OrderId: Int,
    @ColumnInfo(name = "Date") val date: String,
    @ColumnInfo(name = "TrashType") val type: String,
    @ColumnInfo(name = "Size") val size: String,
    @ColumnInfo(name = "AddressId") val addressId: Int,
    @ColumnInfo(name = "Relevance") val relevance: Boolean,
    @ColumnInfo(name = "ClientId") val clientId: Int,
    @ColumnInfo(name = "WorkerId") val workerId: Int
)
