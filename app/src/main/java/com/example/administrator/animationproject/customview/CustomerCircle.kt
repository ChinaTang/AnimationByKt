package com.example.administrator.animationproject.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by Administrator on 2017/6/20.
 */
class CustomerCircle : View {
    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    constructor(context: Context,
                attrs: AttributeSet?,
                defStyleAttr: Int,
                defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
    }

    private val point: com.example.administrator.animationproject.customview.Point = com.example.administrator.animationproject.customview.Point(100f)

     override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        val paint: Paint = Paint()
        paint.isAntiAlias = true
        paint.color = Color.RED
        paint.style = Paint.Style.FILL
        canvas?.drawCircle(300f, 300f, point.mRaduis, paint)
    }

    fun setPointRadius(raduis: Float){
        point.mRaduis = raduis
        invalidate()
    }
}
