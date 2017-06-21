package com.example.administrator.animationproject.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import com.example.administrator.animationproject.R
import kotlin.properties.Delegates

/**
 * Created by Administrator on 2017/6/21.
 * 将listView的入场动画放到adapter的getView方法里
 *
 */
class AnimationListViewActivity: AppCompatActivity(){

    private var listView: ListView by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view_activity)
        listView = findViewById(R.id.listview)as ListView
    }

}
