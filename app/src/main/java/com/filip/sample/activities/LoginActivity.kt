package com.filip.sample.activities

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.filip.sample.R
import com.filip.sample.views.MyCompositeView
import com.filip.sample.views.MyCustomView

class LoginActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val myButton= findViewById<AppCompatButton>(R.id.myButton)
        myButton.setOnClickListener {
//            val returnIntent =  Intent()
//            returnIntent.putExtra("result","Silvia")
//            setResult(Activity.RESULT_OK,returnIntent)
//            finish()

            //val myTextView = AppCompatTextView(this)
            val myTextView = View.inflate(this,R.layout.my_text_view, null) as AppCompatTextView
            val parentLayout = findViewById<LinearLayoutCompat>(R.id.loginActivityParent)
            val emailTextView = findViewById<EditText>(R.id.emailEditText)
            parentLayout.addView(myTextView)
            myTextView.text = emailTextView.text
        }
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)


        val myCompositeView = findViewById<MyCompositeView>(R.id.myCompoundView)
        myCompositeView.hideFirstTwoCharacters()
        myCompositeView.addBorder()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}