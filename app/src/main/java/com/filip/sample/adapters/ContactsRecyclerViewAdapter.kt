package com.filip.sample.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.filip.sample.R
import com.filip.sample.dataModels.ContactsData
import com.squareup.picasso.Picasso

class ContactsRecyclerViewAdapter :ListAdapter<ContactsData,RecyclerView.ViewHolder>(ContactsDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 100) {
            val inflatedContactsLayout =
                View.inflate(parent.context, R.layout.contacts_list_item, null)
            return ContactsViewHolder(inflatedContactsLayout)
        } else if (viewType == 200){
            val inflatedContactsLayout =
                View.inflate(parent.context, R.layout.contacts_list_item2, null)
            return ContactsViewHolder2(inflatedContactsLayout)
        } else {
            val inflatedContactsLayout =
                View.inflate(parent.context, R.layout.contacts_list_item3,null)
            return ContactsViewHolder3(inflatedContactsLayout)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = getItem(position)
        if (data.type == 1) {
            (holder as ContactsViewHolder).bindData(data)
        } else if (data.type == 2) {
            (holder as ContactsViewHolder2).bindData(data)
        } else {
            (holder as ContactsViewHolder3).bindData(data)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val data = getItem(position)
        if (data.type == 1) {
            return 100
        } else if (data.type == 2) {
            return 200
        } else {
            return 300
        }
    }
}

class ContactsViewHolder(private val mainView: View) :RecyclerView.ViewHolder(mainView){
    fun bindData (data: ContactsData?){
        val contactsListText = mainView.findViewById<AppCompatTextView>(R.id.contacts_list_text)
        val contactImage = mainView.findViewById<ImageView>(R.id.contact_image)
        contactsListText.text = data?.name
        Picasso.get().load(data?.iconUrl).into(contactImage)
    }
}

class ContactsViewHolder2(private val mainView :View) :RecyclerView.ViewHolder(mainView){
    fun bindData (data: ContactsData?){
        val contactImage2 = mainView.findViewById<ImageView>(R.id.contact_image2)
        Picasso.get().load(data?.iconUrl).into(contactImage2)
    }
}
class ContactsViewHolder3(private val mainView :View) :RecyclerView.ViewHolder(mainView){
    fun bindData (data: ContactsData?){
        val contactsListName = mainView.findViewById<AppCompatTextView>(R.id.contact_name)
        contactsListName.text = data?.name
    }
}

class ContactsDiffUtil :DiffUtil.ItemCallback<ContactsData>(){
    override fun areItemsTheSame(oldItem: ContactsData, newItem: ContactsData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ContactsData, newItem: ContactsData): Boolean {
        return oldItem.contactId == newItem.contactId
    }
}