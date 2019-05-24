package com.example.room.repository

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * To make fields unique
 * @Entity(indices = arrayOf(Index(value = ["first_name", "last_name"], unique = true)))
 */

@Entity (indices = arrayOf(Index(value = ["user_name"], unique = true)))
data class UserEntity (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "user_id" ) var userId: Int,
    @ColumnInfo(name = "user_name") var userName: String?,
    @ColumnInfo(name = "user_email") var userEmail: String?,
    @ColumnInfo(name = "user_age") var userAge: Int
)