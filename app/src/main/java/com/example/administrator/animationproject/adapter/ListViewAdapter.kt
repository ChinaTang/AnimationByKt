package com.example.administrator.animationproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.administrator.animationproject.R
import kotlin.properties.Delegates

/**
 * Created by Administrator on 2017/6/21.
 */
class ListViewAdapter(val context: Context, val srcList: List<String>): BaseAdapter(){

    override fun getItem(position: Int): Any {
        return  srcList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int = srcList.size

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView;
        if(view == null){
            val viewHolder: ViewHolder = ViewHolder()
            view = LayoutInflater.from(context).inflate(R.layout.list_view_item, parent, false)
            viewHolder.textView = view.findViewById(R.id.text_item)as TextView
            viewHolder.textView.text = srcList[position]
            view.setTag(viewHolder)
        }else{
            val viewHolder: ViewHolder = view.getTag()as ViewHolder
            viewHolder.textView.text = srcList[position]
        }
        return view!!
    }

    class ViewHolder{
        var textView: TextView by Delegates.notNull()
    }

}