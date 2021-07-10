package com.example.customviewtask

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CustomView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    companion object {
        private const val DEFAULT_SCALE = 1.0f
    }

    private val paint = Paint()
    private var size = 500
    var scale = DEFAULT_SCALE
        set(scale) {
            if (scale <= DEFAULT_SCALE) {
                field = scale
                requestLayout()
            } else {
                field = DEFAULT_SCALE
            }
        }

    init {
        paint.isAntiAlias = true
        setupAttributes(attrs)
    }

    private fun setupAttributes(attrs: AttributeSet?) {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomView, 0, 0)
        scale = typedArray.getFloat(R.styleable.CustomView_scale_width, DEFAULT_SCALE)
        typedArray.recycle()
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        setMeasuredDimension((scale * size).toInt(),size)
    }

    override fun onDraw(canvas: Canvas) {

        super.onDraw(canvas)
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK
        val radius = size / 2f
        canvas.drawCircle(size / 2f, size / 2f, radius, paint)

    }

}