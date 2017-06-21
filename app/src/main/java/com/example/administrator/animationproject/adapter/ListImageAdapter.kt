package com.example.administrator.animationproject.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import kotlin.properties.Delegates

/**
 * Created by Administrator on 2017/6/21.
 */
class ListImageAdapter(val context: Context, val srcList: ArrayList<Int>, val listView: ListView): BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if(view == null){
            //convertView = LayoutInflater.
        }
        return view!!
    }

    override fun getItem(position: Int): Any = srcList[position % srcList.size]

    override fun getItemId(position: Int): Long = position.toLong();

    override fun getCount(): Int = srcList.size

    private class ViewHolder{
        var imageView: ImageView by Delegates.notNull()
    }

}