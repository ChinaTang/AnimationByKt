package com.example.administrator.animationproject.activity

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.BounceInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.administrator.animationproject.R
import com.example.administrator.animationproject.customview.CustomerCircle
import com.example.administrator.animationproject.singletone.SingleTone
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private var animationImg: ImageView by Delegates.notNull()

    private var value_animation: Button by Delegates.notNull()

    private var object_anim: Button by Delegates.notNull()

    private var circleImg: CustomerCircle by Delegates.notNull()

    private var custom_ainm: Button by Delegates.notNull()

    private var animationText: TextView by Delegates.notNull()

    private var color_animation: Button by Delegates.notNull()

    private var next: Button by Delegates.notNull()

    private val singleTone: SingleTone = SingleTone.get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        animationImg = findViewById(R.id.img)as ImageView
        value_animation = findViewById(R.id.value_animation)as Button
        object_anim = findViewById(R.id.object_anim)as Button
        circleImg = findViewById(R.id.circle)as CustomerCircle
        custom_ainm = findViewById(R.id.custom_anim)as Button
        animationText = findViewById(R.id.tv)as TextView
        color_animation = findViewById(R.id.custom_background)as Button
        next = findViewById(R.id.next)as Button

        object_anim.setOnClickListener { forObjectAnimation() }
        value_animation.setOnClickListener { view->  forValueAnimation()}
        animationImg.setOnClickListener { Toast.makeText(this, "ClickedImag", Toast.LENGTH_SHORT).show() }
        custom_ainm.setOnClickListener { forCustomAnumation() }
        color_animation.setOnClickListener { forBackgroundAnimation() }
        next.setOnClickListener {
            val test = ListViewActivity::class.java
            val mIntent: Intent = Intent(this@MainActivity, ListViewActivity::class.java)
            startActivity(mIntent)
        }
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

    /**
     * 属性动画是为通过反射获取到空间中的set方法，所以可以改变大部分属性
     */
    private fun forBackgroundAnimation(){
        val animation = ObjectAnimator.ofInt(animationText, "BackgroundColor",
                0xffff00ff.toInt(), 0xffffff00.toInt(), 0xffff00ff.toInt())
        animation.setDuration(3000)
        animation.start()
    }

}
