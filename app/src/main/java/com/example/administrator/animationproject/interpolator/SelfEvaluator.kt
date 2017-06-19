package com.example.administrator.animationproject.interpolator

import android.animation.TypeEvaluator

/**
 * Created by Administrator on 2017/6/19.
 * 返回的是动画实际偏移量
 */
class SelfEvaluator: TypeEvaluator<Int>{
    override fun evaluate(fraction: Float, startValue: Int?, endValue: Int?): Int
            = (startValue!! + fraction * (endValue!! - startValue!!)) as Int

}