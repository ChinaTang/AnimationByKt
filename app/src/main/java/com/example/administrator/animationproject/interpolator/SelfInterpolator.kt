package com.example.administrator.animationproject.interpolator

import android.animation.TimeInterpolator

/**
 * Created by Administrator on 2017/6/19.
 */
class SelfInterpolator: TimeInterpolator{
    override fun getInterpolation(input: Float): Float {
        return input
    }

}