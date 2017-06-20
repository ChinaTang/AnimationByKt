package com.example.administrator.animationproject

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.BounceInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.administrator.animationproject.customview.CustomerCircle
import com.example.administrator.animationproject.singletone.SingleTone
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private var animationImg: ImageView by Delegates.notNull()

    private var value_animation: Button by Delegates.notNull()

    private var object_anim: Button by Delegates.notNull()

    private var circleImg: CustomerCircle by Delegates.notNull()

    private var custom_ainm: Button by Delegates.notNull()

    private val singleTone: SingleTone = SingleTone.get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        animationImg = findViewById(R.id.img)as ImageView
        value_animation = findViewById(R.id.value_animation)as Button
        object_anim = findViewById(R.id.object_anim)as Button
        circleImg = findViewById(R.id.circle)as CustomerCircle
        custom_ainm = findViewById(R.id.custom_anim)as Button
        object_anim.setOnClickListener { forObjectAnimation() }
        value_animation.setOnClickListener { view->  forValueAnimation()}
        animationImg.setOnClickListener { Toast.makeText(this, "ClickedImag", Toast.LENGTH_SHORT).show() }
        custom_ainm.setOnClickListener { forCustomAnumation() }
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

    /**
     * 使用objectAnimation
     */
    private fun forObjectAnimation(){
        val animation: ObjectAnimator
                = ObjectAnimator.ofFloat(animationImg, "scaleX", 0f, 3f, 1f)
        animation.setDuration(3000)
        animation.start()
    }

    /**
     * 使用自定义ObjectAnimation
     */
    private fun forCustomAnumation(){
        val animation: ObjectAnimator = ObjectAnimator.ofFloat(circleImg, "pointRadius", 0f, 300f, 100f)
        animation.setDuration(3000)
        animation.start()
    }

}
