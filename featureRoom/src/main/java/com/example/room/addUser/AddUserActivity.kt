package com.example.room.addUser


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.room.databinding.ActivityAddUserBinding
import org.jetbrains.anko.toast


class AddUserActivity : AppCompatActivity() {

    lateinit var dataBinding: ActivityAddUserBinding
    lateinit var addUserViewModel: AddUserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDataBinding()
        initObserver()
    }

    private fun initDataBinding() {
        // Obtain the ViewModel component
        addUserViewModel = ViewModelProviders.of(this).get(AddUserViewModel::class.java)

        // Inflate view and obtain an instance of the binding class.
        dataBinding = DataBindingUtil.setContentView(this, com.example.room.R.layout.activity_add_user)

        // Assign the component to a property in the binding class.
        dataBinding.addUserVM = addUserViewModel

        // Specify the current activity as the lifecycle owner.
        dataBinding.lifecycleOwner = this
    }

    private fun initObserver(){
        addUserViewModel.getIsDataSaved().observe(this, Observer {
            when (it.peekContent()) {
                true -> {
                    toast("Data saved")
                    finish()
                }
                false -> toast("Enter valid details")
            }
        })
    }

}