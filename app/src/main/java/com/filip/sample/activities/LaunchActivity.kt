package com.filip.sample.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import com.filip.sample.R

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("silvia", "onCreate")
        setContentView(R.layout.activity_vehicle_data)
        Toast.makeText(this,R.string.app_name,Toast.LENGTH_LONG).show()
        val mySelect2 = findViewById<AppCompatTextView>(R.id.select2)
//        val myImage = findViewById<AppCompatImageView>(R.id.myImage)
//        myButton.setOnClickListener {
//            if (myImage.visibility == View.GONE) {
//                myImage.visibility = View.VISIBLE
//            } else {
//                myImage.visibility = View.GONE
//            }
//    }
        mySelect2.setOnClickListener {
//            val loginIntent = Intent(this, LoginActivity::class.java)
//            startActivity(loginIntent)
//            finish()
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivityForResult(loginIntent,5)
        }

        val mySelect1 = findViewById<AppCompatTextView>(R.id.select)
        mySelect1.setOnClickListener {
//            val intent = Intent()
//            intent.action = Intent.ACTION_APPLICATION_PREFERENCES
//            startActivity(intent)
            val intent = Intent()
            intent.action = Intent.ACTION_CAMERA_BUTTON
            val pm = packageManager
            val cameraIntent = intent.resolveActivity(pm)
            if (cameraIntent == null){
                Toast.makeText(this,R.string.no_camera,Toast.LENGTH_LONG).show()
            }
            else{
                startActivity(intent)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==5){
            if (resultCode== Activity.RESULT_OK){
                val newText = data?.extras?.getString("result")
                val resetText = findViewById<AppCompatTextView>(R.id.system_error)
                resetText.text = newText
            } else {
                val resetText = findViewById<AppCompatTextView>(R.id.system_error)
                resetText.text = "cancelled"
            }

        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("silvia","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("silvia","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("silvia","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("silvia","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("silvia","onDestroy")
    }
}