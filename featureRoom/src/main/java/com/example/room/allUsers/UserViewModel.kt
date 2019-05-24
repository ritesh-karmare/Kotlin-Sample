package com.example.room.allUsers

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.room.repository.AppDb
import com.example.room.repository.UserEntity
import com.example.room.repository.UserRepository
import org.jetbrains.anko.doAsync

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository
    val allWords: LiveData<List<UserEntity>>

    init {
        val wordsDao = AppDb.getDatabase(application).userDao()
        repository = UserRepository(wordsDao)
        allWords = repository.allUsers
    }

    fun getAllUsers() : LiveData<List<UserEntity>> {
        return repository.allUsers
    }

    fun deleteUser(userId : Int){
        doAsync {
            repository.deleteUser(userId)
        }
    }

    fun insertUser(user : UserEntity){
        doAsync {
            repository.insert(user)
        }
    }
}