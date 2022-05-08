package com.example.easytresh.repository.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.easytresh.repository.database.entity.Users

@Dao
interface UsersDao {
    @Query("SELECT * FROM Users")
    fun getAllUsers(): List<Users>

    @Query("SELECT * FROM Users WHERE UserId IN (:id)")
    fun getUserById(id: Int): Users

    @Query("SELECT * FROM Users WHERE Phone IN (:phone)")
    fun getUserByPhone(phone: String): Users

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: Users)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(user: Users)

    @Delete
    fun delete(user: Users)

}