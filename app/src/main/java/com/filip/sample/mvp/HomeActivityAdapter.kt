package com.filip.sample.mvp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.filip.sample.R
import com.filip.sample.api.apiModels.EntriesResponse
import com.filip.sample.api.apiModels.Entry

const val ENTRY_KEY = "entry_key"

class HomeActivityAdapter(private val homeActivity: HomeActivity) :ListAdapter<Entry,EntriesViewHolder>(EntriesDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntriesViewHolder {
        val inflatedLayout = View.inflate(parent.context, R.layout.mvp_entry_item, null)
        return EntriesViewHolder(inflatedLayout,homeActivity)
    }

    override fun onBindViewHolder(holder: EntriesViewHolder, position: Int) {
        val entry = getItem(position)
        holder.bindData(entry)
    }

}

class EntriesViewHolder(private val mainView :View,private val homeActivity: HomeActivity) :RecyclerView.ViewHolder(mainView){
    fun bindData (entryData: Entry){
        val entryApi = mainView.findViewById<AppCompatTextView>(R.id.api)
        val entryDescription = mainView.findViewById<AppCompatTextView>(R.id.description)
        entryApi.text = entryData.api
        entryDescription.text = entryData.description
        mainView.setOnClickListener {
            val detailedEntryIntent = Intent(homeActivity, SecondMvpActivity::class.java)
            //Repository.entry = entryData
            detailedEntryIntent.putExtra(ENTRY_KEY, entryData)
            homeActivity.startActivity(detailedEntryIntent)
        }

    }

}


class EntriesDiffUtil : DiffUtil.ItemCallback<Entry>() {
    override fun areItemsTheSame(oldItem: Entry, newItem: Entry): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Entry, newItem: Entry): Boolean {
        return oldItem.api == newItem.api
    }

}