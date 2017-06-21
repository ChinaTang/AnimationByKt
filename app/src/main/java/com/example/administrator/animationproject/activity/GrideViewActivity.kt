package com.example.administrator.animationproject.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.GridLayoutAnimationController
import android.widget.GridView
import com.example.administrator.animationproject.R
import com.example.administrator.animationproject.adapter.GridViewAdapter
import kotlin.properties.Delegates

/**
 * Created by Administrator on 2017/6/21.
 */
class GrideViewActivity: AppCompatActivity(){

    private var gridView: GridView by Delegates.notNull()

    private val srcList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gride_view_activity)
        initData()
        initView()
    }

    private fun initView(){
        gridView = findViewById(R.id.gird_view)as GridView
        gridView.adapter = GridViewAdapter(this, srcList)
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.slide_item_anim)
        val animationContrl: GridLayoutAnimationController = GridLayoutAnimationController(animation)
        animationContrl.columnDelay = 0.75f
        animationContrl.rowDelay = 0.5f
        animationContrl.direction = GridLayoutAnimationController.DIRECTION_BOTTOM_TO_TOP or GridLayoutAnimationController.DIRECTION_LEFT_TO_RIGHT
        animationContrl.directionPriority = GridLayoutAnimationController.PRIORITY_NONE
        gridView.layoutAnimation = animationContrl
        gridView.startLayoutAnimation()
    }

    private fun initData(){
        for(i in 1..35){
            srcList.add("data$i")
        }
    }
}
