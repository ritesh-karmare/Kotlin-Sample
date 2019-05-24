package com.example.room.addUser

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.room.EventWrapper
import com.example.room.repository.AppDb
import com.example.room.repository.UserEntity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class AddUserViewModel(application: Application) : AndroidViewModel(application) {

    var userName: String = ""
    var userEmail: String = ""
    var userAge: String = ""

    var isDataSaved: MutableLiveData<EventWrapper<Boolean>> = MutableLiveData()

    fun getIsDataSaved(): MutableLiveData<EventWrapper<Boolean>> = isDataSaved

    fun saveUser() {
        if (!userName.isEmpty() && !userEmail.isEmpty() && !userAge.isEmpty()) {
            doAsync {
                AppDb.getDatabase(getApplication()).userDao()
                    .insertUser(UserEntity(0, userName, userEmail, userAge.toInt()))

                uiThread {
                    isDataSaved.value = EventWrapper(true)
                }
            }
        } else isDataSaved.value = EventWrapper(false)
    }
}