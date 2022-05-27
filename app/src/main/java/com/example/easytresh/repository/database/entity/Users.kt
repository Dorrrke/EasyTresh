package com.example.easytresh.repository.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity()
data class Users(
    @field:SerializedName("userId")
    @PrimaryKey(autoGenerate = true) val UserId: Int,
    @field:SerializedName("name")
    @ColumnInfo(name = "Name") val userName: String,
    @field:SerializedName("phone")
    @ColumnInfo(name = "Phone") val userPhone: String,
    @field:SerializedName("password")
    @ColumnInfo(name = "Password") val userPass: String,
    @field:SerializedName("registrationDate")
    @ColumnInfo(name = "Registration_date") val registrationDate: String
)
