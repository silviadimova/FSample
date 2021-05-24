package com.filip.sample.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import com.filip.sample.R

class MyCompositeView(
        context: Context,
        attributeSet: AttributeSet? = null,
        defStyle: Int = 0
) :FrameLayout(context, attributeSet, defStyle) {

    private lateinit var myTextView: AppCompatTextView

    init {
        inflateAndInit()
    }

    private fun inflateAndInit() {
        val myInflatedTextView = View.inflate(context, R.layout.my_text_view, null) as AppCompatTextView
        addView(myInflatedTextView)
        myTextView = findViewById<AppCompatTextView>(R.id.blabla)

    }

    fun setDoubleText() {
        myTextView.text = "adsad adsd sad as asd sa"
    }

    fun hideFirstTwoCharacters() {

    }

    fun addBorder() {

    }

}