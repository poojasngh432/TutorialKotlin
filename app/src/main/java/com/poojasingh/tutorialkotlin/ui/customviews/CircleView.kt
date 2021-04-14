package com.poojasingh.tutorialkotlin.ui.customviews

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.poojasingh.tutorialkotlin.R

class CircleView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    var paint: Paint = Paint()
    var isCenter = false
    var centerOfX = 0F
    var centerOfY = 0F
    var radiusOfCircleView = 0F

    init {
        var attributeArray: TypedArray? = context.theme.obtainStyledAttributes(
            attributeSet, R.styleable.circleview, 0, 0
        )
        paint.color = attributeArray?.getColor(
            R.styleable.circleview_circle_background,
            ContextCompat.getColor(context, android.R.color.background_dark)
        ) ?: android.R.color.black
        isCenter = attributeArray?.getBoolean(R.styleable.circleview_onCenter, false) ?: false;
        radiusOfCircleView = attributeArray?.getDimension(R.styleable.circleview_circle_radius, 140F) ?: 140F
        paint.strokeWidth = 40f
        paint.style = Paint.Style.STROKE
        // Constructor Call
    }
    override fun onDraw(canvas: Canvas?) {
        isCenter?.let {
            centerOfX = (width / 2).toFloat()
            centerOfY = (height / 2).toFloat()
        }
        canvas?.drawCircle(centerOfX, centerOfY, radiusOfCircleView, paint)
        super.onDraw(canvas)
    }
}