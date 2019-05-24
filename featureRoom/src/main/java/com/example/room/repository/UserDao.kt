package com.example.room.repository

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity) : Long


    @Update
    fun updateUser(user: UserEntity)

    @Delete
    fun deleteUser(user: UserEntity)


    @Query("SELECT * FROM UserEntity")
    fun loadAllUsers(): LiveData<List<UserEntity>>

    @Query("SELECT user_name FROM UserEntity")
    fun loadAllUserName(): List<String>

    @Query("SELECT * FROM UserEntity WHERE user_name == :name")
    fun getGenderByName(name: String): List<UserEntity>

    @Query("DELETE FROM UserEntity")
    fun deleteAll()

    @Query("DELETE FROM UserEntity WHERE user_id = :userId")
    fun deleteUserByUserId(userId: Int)

}