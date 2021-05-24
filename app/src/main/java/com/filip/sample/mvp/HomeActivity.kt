package com.filip.sample.mvp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.filip.sample.R
import com.filip.sample.api.apiModels.EntriesResponse
import com.filip.sample.api.apiModels.Entry

class HomeActivity :AppCompatActivity(), HomeActivityPresenter.View {

    private val presenter: HomeActivityPresenter by lazy { HomeActivityPresenter(this, HomeActivityModel(getPreferences(Context.MODE_PRIVATE))) }
    private val homeActivityAdapter = HomeActivityAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity_mvp_layout)
        val homeActivityRecyclerView = findViewById<RecyclerView>(R.id.mvp_recycler_view)
        homeActivityRecyclerView.adapter = homeActivityAdapter
        homeActivityRecyclerView.isScrollbarFadingEnabled = false
        presenter.readPreference()


        findViewById<AppCompatButton>(R.id.home_mvp_button).setOnClickListener {
            val text = findViewById<EditText>(R.id.home_mvp_text).text.toString()
            val email = findViewById<EditText>(R.id.home_mvp_email).text.toString()
            val password = findViewById<EditText>(R.id.home_mvp_password).text.toString()
            presenter.onSubmit(text,email,password)
            presenter.respondToCredentials(text,email,password)

        }
    }

    override fun drawText(text: String,email: String,password: String) {
        val textDisplay = findViewById<AppCompatTextView>(R.id.text_display)
        textDisplay.text = String.format(getString(R.string.my_temp), text,email,password)
        textDisplay.visibility = View.VISIBLE
    }

    override fun displayCache(cachedText: String, cachedEmail: String, cachedPassword: String) {
        findViewById<EditText>(R.id.home_mvp_text).setText(cachedText)
        findViewById<EditText>(R.id.home_mvp_email).setText(cachedEmail)
        findViewById<EditText>(R.id.home_mvp_password).setText(cachedPassword)
    }

    override fun displayEntries(entriesData: EntriesResponse?) {
//        val filteredList : MutableList<Entry> = mutableListOf()
//        entriesData?.entries?.forEach {
//            if (it.api.contains("cat", true)){
//                filteredList.add(it)
//            }
//        }

        val filteredList : List<Entry>? = entriesData?.entries?.filter { it.api.contains("cat", true) }
        homeActivityAdapter.submitList(filteredList)

    }

    override fun showError(message: Int){
        val inputError = findViewById<AppCompatTextView>(R.id.text_error)
        inputError.setText(message)
        inputError.visibility = View.VISIBLE
    }

    override fun hideError() {
        findViewById<AppCompatTextView>(R.id.text_error).visibility = View.GONE
    }

    override fun displayApiError(error: String) {
        Toast.makeText(this, "API error $error", Toast.LENGTH_LONG).show()
    }


    override fun navigateTo(target: Class<*>) {
        val secondActivityIntent = Intent(this, target)
        startActivity(secondActivityIntent)
        finish()
    }

    fun listItemClickListener(entryData: Entry) {
        
    }



}