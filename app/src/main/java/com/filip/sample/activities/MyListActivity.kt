package com.filip.sample.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.filip.sample.R
import com.filip.sample.adapters.MyRecyclerViewAdapter

class MyListActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_recycler_view)
        val myRecyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val myAdapter = MyRecyclerViewAdapter()

//        val myDataList = mutableListOf("Silvia", "Stoycho", "Filip", "Irmena", "Baba", "Dado", "Chuchu", "Simba", "Valchan", "Ivan", "Dragan")
        myRecyclerView.adapter = myAdapter
//        myAdapter.submitList(myDataList)
    }

}