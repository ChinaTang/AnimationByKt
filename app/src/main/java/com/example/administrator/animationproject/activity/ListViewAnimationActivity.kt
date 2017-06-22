package com.example.administrator.animationproject.activity

import `in`.srain.cube.views.ptr.PtrClassicFrameLayout
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import com.example.administrator.animationproject.R
import com.example.administrator.animationproject.loadmor.LoadMoreListViewContainer
import kotlin.properties.Delegates

/**
 * Created by Administrator on 2017/6/22.
 * listView上拉加载，下拉刷新
 * 使用jar包
 */
class ListViewAnimationActivity: AppCompatActivity(){

    private var listView: ListView by Delegates.notNull()

    private var ptrFrame: PtrClassicFrameLayout by Delegates.notNull()

    private var loadmore: LoadMoreListViewContainer by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view_animation_activity)
        listView  = findViewById(R.id.listview)as ListView
        ptrFrame = findViewById(R.id.ptr_frame)as PtrClassicFrameLayout
        loadmore = findViewById(R.id.load_more)as LoadMoreListViewContainer
    }
}
