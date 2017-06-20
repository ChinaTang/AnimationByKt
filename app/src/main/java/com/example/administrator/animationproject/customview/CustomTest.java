package com.example.administrator.animationproject.customview;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/6/20.
 */

public class CustomTest extends View {
    public CustomTest(Context context) {
        super(context);
    }

    public CustomTest(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
    }

    public CustomTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomTest(Context context,
                      @Nullable AttributeSet attrs,
                      int defStyleAttr,
                      int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private Point mPoint = new Point();


}
