package com.example.administrator.animationproject.interpolator

import android.animation.TimeInterpolator

/**
 * Created by Administrator on 2017/6/19.
 * 插值器返回的是动画的时间线百分比
 */
class SelfInterpolator: TimeInterpolator{
    override fun getInterpolation(input: Float): Float {
        return input
    }

}