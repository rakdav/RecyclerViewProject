package com.example.recyclerviewproject.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerviewproject.domain.State

class StateItemDiffCallBack: DiffUtil.ItemCallback<State>() {
    override fun areItemsTheSame(oldItem: State, newItem: State): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: State, newItem: State): Boolean {
        return oldItem==newItem
    }

}