package com.example.easytresh.repository.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Workers (
    @PrimaryKey(autoGenerate = true) val WorkerId: Int,
    @ColumnInfo(name = "Name") val userName: String,
    @ColumnInfo(name = "Phone") val userPhone: String,
    @ColumnInfo(name = "Password") val userPass: String,
    @ColumnInfo(name = "Registration_date") val registrationDate: String
    )
