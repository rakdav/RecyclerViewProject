package com.example.recyclerviewproject.presentation


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.recyclerviewproject.R
import com.example.recyclerviewproject.databinding.StateItemBinding
import com.example.recyclerviewproject.domain.State

class StateAdapter:ListAdapter<State,StateItemViewHolder>(StateItemDiffCallBack()) {

    var onStateItemOnClickListener:((State)->Unit)?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateItemViewHolder {
        val view=StateItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return StateItemViewHolder(view)
    }
    override fun onBindViewHolder(holder: StateItemViewHolder, position: Int) {
        val stateItem=getItem(position)
        holder.itemBinding.textView.text=stateItem.name
        holder.itemBinding.textView2.text=stateItem.capital
        holder.itemBinding.imageView.setImageResource(R.drawable.russia)
        holder.itemView.setOnClickListener {
            onStateItemOnClickListener?.invoke(stateItem)
        }
    }
}