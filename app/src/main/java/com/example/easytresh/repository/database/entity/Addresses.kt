package com.example.easytresh.repository.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Users::class,
        parentColumns = arrayOf("UserId"),
        childColumns = arrayOf("ClientId"),
        onDelete = CASCADE
    )]
)
data class Addresses(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "Country") val country: String,
    @ColumnInfo(name = "City") val city: String,
    @ColumnInfo(name = "Street") val street: String,
    @ColumnInfo(name = "House_number") val houseNumber: Int,
    @ColumnInfo(name = "Frame") val frame: Int,
    @ColumnInfo(name = "Front_door") val frontDoor: Int,
    @ColumnInfo(name = "Floor") val floor: Int,
    @ColumnInfo(name = "Flat") val flat: Int,
    @ColumnInfo(name = "ClientId") val clientId: Int
)
