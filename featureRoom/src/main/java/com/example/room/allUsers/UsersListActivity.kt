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

    // Observer the data changed in the DB (User added/deleted)
    private fun setUpObserver() {
        userViewModel.getAllUsers().observe(this, Observer {
            if (it.isEmpty()){
                dataBinding.rvUsers.visibility = View.GONE
                dataBinding.tvNoData.visibility = View.VISIBLE
            }else{
                usersAdapter.setUsers(it)
                dataBinding.rvUsers.scrollToPosition(usersAdapter.itemCount - 1)

                dataBinding.rvUsers.visibility = View.VISIBLE
                dataBinding.tvNoData.visibility = View.GONE
            }
        })
    }

    // init RecyclerView
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

    // Init swipeListener to delete user by implementing SwipeToDeleteCallback
    private fun initSwipeListener() {
        ItemTouchHelper(object : SwipeToDeleteCallback(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, i: Int) {
                deleteItem(viewHolder.adapterPosition)
            }
        }).attachToRecyclerView(dataBinding.rvUsers)
    }

    // Delete the item from list on swipe
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

    // on addUser fab click
    fun fabClick(view: View) {
        startActivity(Intent(this, AddUserActivity::class.java))
    }
}