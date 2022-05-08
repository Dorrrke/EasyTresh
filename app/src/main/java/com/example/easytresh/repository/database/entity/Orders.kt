package com.example.easytresh.repository.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Orders(
    @PrimaryKey(autoGenerate = true) val OrderId: Int,
    @ColumnInfo(name = "Date") val date: String,
    @ColumnInfo(name = "address") val addr: String,
    @ColumnInfo(name = "ClientId") val clientId: Int,
    @ColumnInfo(name = "WorkerId") val workerId: Int)
