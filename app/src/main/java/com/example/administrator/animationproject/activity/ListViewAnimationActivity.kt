package com.example.administrator.animationproject.activity

import `in`.srain.cube.views.ptr.PtrClassicFrameLayout
import `in`.srain.cube.views.ptr.PtrDefaultHandler
import `in`.srain.cube.views.ptr.PtrFrameLayout
import `in`.srain.cube.views.ptr.PtrHandler
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.ListView
import com.example.administrator.animationproject.R
import com.example.administrator.animationproject.adapter.ListViewAdapter
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

    private var headView: View by Delegates.notNull()

    private var srcList: ArrayList<String>  = ArrayList()

    private var adapter: ListViewAdapter by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view_animation_activity)
        initData()
        initView()
    }

    private fun initView(){
        listView  = findViewById(R.id.listview)as ListView
        ptrFrame = findViewById(R.id.ptr_frame)as PtrClassicFrameLayout
        loadmore = findViewById(R.id.load_more)as LoadMoreListViewContainer
        listView.adapter = adapter
        headView = LayoutInflater.from(this).inflate(R.layout.list_view_empty_head, null)
        listView.addHeaderView(headView)
        ptrFrame.setLoadingMinTime(1000)
        ptrFrame.setPtrHandler(object : PtrHandler{
            override fun onRefreshBegin(frame: PtrFrameLayout?) {
                ptrFrame.postDelayed(object : Runnable{
                    override fun run() {
                        srcList.clear()
                        for(i in 1..20){
                            srcList.add("data#$i")
                        }

                        adapter.notifyDataSetChanged()
                        //加入数据，刷新列表
                        ptrFrame.refreshComplete();
                        //第一个参数是：数据是否为空；第二个参数是：是否还有更多数据
                        //loadmore.loadMoreFinish(false, true);
                    }

                }, 500)
            }

            override fun checkCanDoRefresh(frame: PtrFrameLayout?, content: View?, header: View?): Boolean {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header)
            }

        })


        loadmore.setAutoLoadMore(false)
        loadmore.useDefaultFooter()
        loadmore.setLoadMoreHandler {  }

    }

    private fun initData(){
        for(i in 1..20){
            srcList.add("data#$i")
        }
        adapter = ListViewAdapter(this, srcList)
    }
}
