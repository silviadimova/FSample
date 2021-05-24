package com.filip.sample.views

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.filip.sample.R

class MyCustomView(
        context: Context,
        attributeSet: AttributeSet? = null,
        defStyle: Int = 0
) :View(context, attributeSet, defStyle) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

       // canvas?.drawColor(ContextCompat.getColor(context,R.color.black))
    }

}