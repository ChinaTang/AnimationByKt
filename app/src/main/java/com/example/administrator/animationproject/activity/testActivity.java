package com.example.administrator.animationproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/21.
 */

public class testActivity extends AppCompatActivity {

    private Button bn01;

    private ArrayList<Class> mArrayList = new ArrayList<>();

    @Override
    public void onCreate(Bundle saveInstanceBundle){
        super.onCreate(saveInstanceBundle);
        mArrayList.add(ListViewActivity.class);
        bn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(testActivity.this, mArrayList.get(0));
            }
        });
    }
}
