package com.example.easytresh.repository.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Users(
    @PrimaryKey(autoGenerate = true) val UserId: Int,
    @ColumnInfo(name = "Name") val userName: String,
    @ColumnInfo(name = "Phone") val userPhone: String,
    @ColumnInfo(name = "Password") val userPass: String
)
