package com.filip.sample.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.filip.sample.R
import com.filip.sample.adapters.ContactsRecyclerViewAdapter
import com.filip.sample.dataModels.ContactsData

class ContactsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contacts_recycler_view)
        val contactsRecyclerView = findViewById<RecyclerView>(R.id.contacts_recycler_view)
        val contactsRecyclerViewAdapter = ContactsRecyclerViewAdapter()

        val contact1 = ContactsData(1,1,"https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/male/45.png","Ivan Service Nadejda asfdgh ajhgdhagsd sa das")
        val contact2 = ContactsData(2,2,"https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/male/44.png","Ivanchev 04 RPU")
        val contact3 = ContactsData(3,3,"https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/male/43.png","Ivanchev 06 RPU")
        val contact4 = ContactsData(1,4,"https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/male/45.png","Ivanchev 09 RPU")
        val contact5 = ContactsData(2, 5,"https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/male/45.png","Ivan Service Nadejda asfdgh ajhgdhagsd sa das")
        val contact6 = ContactsData(3,6,"https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/male/47.png","Ivan Service Nadejda asfdgh ajhgdhagsd sa das")
        val contact7 = ContactsData(2, 7,"https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/male/45.png","Ivanchev 4899 RPU")
        val contact8 = ContactsData(1,8,"https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/male/40.png","Ivan Service Nadejda asfdgh ajhgdhagsd sa das")
        val contact9 = ContactsData(3,9,"https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/male/39.png","Ivan Service Nadejda asfdgh ajhgdhagsd sa das")

        val contactsDataList = mutableListOf<ContactsData>(contact1,contact2,contact3,contact4,contact5,contact6,contact7,contact8,contact9)

        contactsRecyclerView.adapter = contactsRecyclerViewAdapter
        contactsRecyclerViewAdapter.submitList(contactsDataList)

    }
}