package com.filip.sample.adapters

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import com.filip.sample.R

class MyRecyclerViewAdapter : ListAdapter<String, MyViewHolder>(MyDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflatedLayout = View.inflate(parent.context, R.layout.my_list_view_item, null)
        return MyViewHolder(inflatedLayout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        holder.drawData(data)
    }

}

class MyViewHolder(private val parent: View) :RecyclerView.ViewHolder(parent){

    fun drawData(data: String) {
        val myTextView = parent.findViewById<AppCompatTextView>(R.id.my_list_text_view)
        myTextView.text = data
    }

}

class MyDiffUtil :DiffUtil.ItemCallback<String>(){
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

}