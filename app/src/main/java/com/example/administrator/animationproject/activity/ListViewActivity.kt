package com.example.administrator.animationproject.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.ListView
import com.example.administrator.animationproject.R
import com.example.administrator.animationproject.adapter.ListViewAdapter
import kotlin.properties.Delegates

/**
 * Created by Administrator on 2017/6/21.
 */
class ListViewActivity: AppCompatActivity(){

    private var listView: ListView by Delegates.notNull()

    private val srcArray :ArrayList<String> = ArrayList()

    private val classArray: ArrayList<Class<*>> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view_activity)
        initData()
        initView()
    }

    private fun initView(){
        listView = findViewById(R.id.listview)as ListView
        listView.adapter = ListViewAdapter(this, srcArray)
        var animation: Animation = AnimationUtils.loadAnimation(this, R.anim.slide_item_anim)
        var layoutAnimationController: LayoutAnimationController = LayoutAnimationController(animation)
        layoutAnimationController.delay = 0.3f
        listView.layoutAnimation = layoutAnimationController
        listView.startLayoutAnimation()
        listView.setOnItemClickListener { parent, view, position, id ->
            val mIntent: Intent = Intent(this@ListViewActivity, classArray[position])
            startActivity(mIntent)
        }
    }

    private fun initData(){
        srcArray.add("gridAnimation")
        classArray.add(GrideViewActivity::class.java)
    }
}