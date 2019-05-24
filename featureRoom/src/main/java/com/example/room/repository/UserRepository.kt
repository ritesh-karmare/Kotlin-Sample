package com.example.room.repository

import androidx.lifecycle.LiveData

class UserRepository(private val userDao : UserDao){

    val allUsers: LiveData<List<UserEntity>> = userDao.loadAllUsers()


    fun insert(user: UserEntity) {
        userDao.insertUser(user)
    }

    fun deleteUser(userId : Int){
        userDao.deleteUserByUserId(userId)
    }

}