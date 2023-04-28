package com.onlye.jetpackmvvm.test

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 *@author onlye_lc
 *2023/4/26
 *@description
 **/
class MyView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    View(context, attrs, defStyleAttr) {

    lateinit var mOnNumChangeListener: OnNumChangeListener
    var num = 0
        //        get() {
//            return field
//        }
        set(value) {
            field = value
            invalidate()
        }

    private val paint: Paint
    private val textPaint: Paint

    init {
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.BLACK
        textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        textPaint.color = Color.WHITE
        textPaint.textSize = 36f

        setOnClickListener {
            num++
            invalidate()
            mOnNumChangeListener.onNumChanged()

        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var measuredHeight = measuredHeight
        var measuredWidth = measuredWidth
        if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST) {
            measuredWidth = 200
        }
        if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST) {
            measuredHeight = 200
        }
        setMeasuredDimension(measuredWidth, measuredHeight)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {
            drawRect(0f, 0f, 200f, 200f, paint)
            drawText("$num", (width / 2).toFloat(), (height / 2).toFloat(), textPaint)
        }
    }

    interface OnNumChangeListener {
        fun onNumChanged()
    }
}