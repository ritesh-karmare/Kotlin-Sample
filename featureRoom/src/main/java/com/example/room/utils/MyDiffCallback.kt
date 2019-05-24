package com.example.room.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.room.repository.UserEntity

class MyDiffCallback(private val newUserEntitys: List<UserEntity>, private val oldUserEntitys: List<UserEntity>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldUserEntitys.size
    }

    override fun getNewListSize(): Int {
        return newUserEntitys.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldUserEntitys[oldItemPosition].userId == newUserEntitys[newItemPosition].userId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldUserEntitys[oldItemPosition] == newUserEntitys[newItemPosition]
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        //you can return particular field for changed item.
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}
