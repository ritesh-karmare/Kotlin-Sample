package com.example.room.allUsers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.room.repository.UserEntity
import com.example.room.utils.MyDiffCallback


class UsersAdapter internal constructor(context: Context) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var words = emptyList<UserEntity>()

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameItemView: TextView = itemView.findViewById(com.example.room.R.id.tv_username)
        val emailItemView: TextView = itemView.findViewById(com.example.room.R.id.tv_useremail)
        val ageItemView: TextView = itemView.findViewById(com.example.room.R.id.tv_userage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = inflater.inflate(com.example.room.R.layout.list_item, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val current = words[position]
        holder.nameItemView.text = current.userName
        holder.emailItemView.text = current.userEmail
        holder.ageItemView.text = current.userAge.toString()
    }

    internal fun setUsers(words: List<UserEntity>) {
        // notifyDataSetChanged() is costly operation; so we use DiffUtil
        val diffResult = DiffUtil.calculateDiff(MyDiffCallback(this.words, words), true)
        diffResult.dispatchUpdatesTo(this)
        this.words = emptyList()
        this.words = words
    }

    override fun getItemCount() = words.size

    fun getItem(position: Int) = words.get(position)

}
