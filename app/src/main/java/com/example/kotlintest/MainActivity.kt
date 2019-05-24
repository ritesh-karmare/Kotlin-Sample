package com.example.kotlintest

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.featurearch.vm.VMDemoActivity
import com.example.room.allUsers.UsersListActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Utils.runAllFunc()
    }

    fun triggerFeatureArch(view : View){
        startActivity(Intent(this,VMDemoActivity::class.java))
    }

    fun triggerFeatureRoom(view : View){
        startActivity(Intent(this, UsersListActivity::class.java))
    }
}