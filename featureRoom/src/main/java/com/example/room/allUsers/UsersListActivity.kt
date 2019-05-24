package com.example.room.allUsers

import android.content.Intent

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.addUser.AddUserActivity
import com.example.room.utils.LinearLayoutManagerWrapper
import com.example.room.utils.SwipeToDeleteCallback
import com.google.android.material.snackbar.Snackbar
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast


class UsersListActivity : AppCompatActivity(), AnkoLogger {

    lateinit var dataBinding: com.example.room.databinding.ActivityUserListBinding
    lateinit var usersAdapter: UsersAdapter
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDataBinding()
        initRecyclerView()
        setUpObserver()
        initSwipeListener()
    }

    private fun initDataBinding() {
        // Obtain the ViewModel component
        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        // Inflate view and obtain an instance of the binding class.
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_list)

        // Assign the component to a property in the binding class.
        dataBinding.viewModel = userViewModel

        // Specify the current activity as the lifecycle owner.
        dataBinding.lifecycleOwner = this
    }

    private fun setUpObserver() {
        userViewModel.getAllUsers().observe(this, Observer {
            usersAdapter.setUsers(it)
            dataBinding.rvUsers.scrollToPosition(usersAdapter.itemCount - 1)
            toast("New data added successfully")
        })
    }

    private fun initRecyclerView() {
        dataBinding.rvUsers.layoutManager = LinearLayoutManagerWrapper(this)
        dataBinding.rvUsers.addItemDecoration(
            DividerItemDecoration(
                this@UsersListActivity,
                DividerItemDecoration.VERTICAL
            )
        )
        usersAdapter = UsersAdapter(this)
        dataBinding.rvUsers.adapter = usersAdapter
    }

    private fun initSwipeListener() {
        ItemTouchHelper(object : SwipeToDeleteCallback(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, i: Int) {
                deleteItem(viewHolder.adapterPosition)
            }
        }).attachToRecyclerView(dataBinding.rvUsers)
    }

    private fun deleteItem(position: Int) {
        val item = usersAdapter.getItem(position)
        userViewModel.deleteUser(item.userId)
        val snackbar = Snackbar
            .make(dataBinding.rvUsers, "Item was removed from the list.", Snackbar.LENGTH_LONG)
        snackbar.setAction("UNDO") {
            userViewModel.insertUser(item)
        }
        snackbar.show()
    }

    fun fabClick(view: View) {
        startActivity(Intent(this, AddUserActivity::class.java))
    }
}