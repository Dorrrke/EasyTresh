package com.example.easytresh.repository.database.dao

import androidx.room.*
import com.example.easytresh.repository.database.entity.Users
import com.example.easytresh.repository.database.entity.Workers

@Dao
interface WorkersDao {
    @Query("SELECT * FROM Workers")
    fun getAllUsers(): List<Workers>

    @Query("SELECT * FROM Workers WHERE WorkerId IN (:id)")
    fun getUserById(id: Int): Workers

    @Query("SELECT * FROM Workers WHERE Phone IN (:phone)")
    fun getUserByPhone(phone: String): Workers

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(worker: Workers)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(worker: Workers)

    @Delete
    fun delete(worker: Workers)
}