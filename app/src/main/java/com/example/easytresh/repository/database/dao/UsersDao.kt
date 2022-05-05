package com.example.easytresh.repository.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.easytresh.repository.database.entity.Users

@Dao
interface UsersDao {
    @Query("SELECT * FROM Users")
    fun getAllUsers(): LiveData<List<Users>>

    @Query("SELECT * FROM Users WHERE UserId=:id")
    fun getUserById(id: Int): Users

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: Users)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(user: Users)

    @Delete
    fun delete(user: Users)

}