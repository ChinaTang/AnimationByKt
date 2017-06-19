package com.example.administrator.animationproject

import android.animation.Animator
import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.BounceInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private var animationImg: ImageView by Delegates.notNull()

    private var value_animation: Button by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        animationImg = findViewById(R.id.img)as ImageView
        value_animation = findViewById(R.id.value_animation)as Button

        value_animation.setOnClickListener { view->  forValueAnimation()}
        animationImg.setOnClickListener { Toast.makeText(this, "ClickedImag", Toast.LENGTH_SHORT).show() }
    }

    /**
     * 使用valueAnimation
     */
    private fun forValueAnimation(){
        var valueAmin: ValueAnimator = ValueAnimator.ofInt(0, 400, 50, 300)
        valueAmin.setDuration(4000)
        valueAmin.addUpdateListener { animation ->
            val intValue = animation.getAnimatedValue() as Int

            animationImg.layout(intValue, intValue, intValue + animationImg.width, intValue
                    + animationImg.height)
        }

        valueAmin.addListener(object : Animator.AnimatorListener{
            override fun onAnimationEnd(animation: Animator?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onAnimationCancel(animation: Animator?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onAnimationStart(animation: Animator?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onAnimationRepeat(animation: Animator?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
        valueAmin.interpolator = BounceInterpolator()
        valueAmin.start()
    }

}
