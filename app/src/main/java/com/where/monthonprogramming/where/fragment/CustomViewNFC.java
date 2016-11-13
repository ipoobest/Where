package com.where.monthonprogramming.where.fragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by RUNGNUENG on 11/13/2016.
 */

public class CustomViewNFC extends View{
    public CustomViewNFC(Context context) {
        super(context);
        init();
    }

    public CustomViewNFC(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomViewNFC(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(21)
    public CustomViewNFC(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setColor(0xFFFF0000);
        canvas.drawCircle(getMeasuredWidth()*26/100,getMeasuredHeight()*75/100,getMeasuredWidth()/20,p);
        canvas.drawCircle(getMeasuredWidth()*11/100,getMeasuredHeight()*20/100,getMeasuredWidth()/20,p);
        canvas.drawCircle(getMeasuredWidth()*65/100,getMeasuredHeight()*45/100,getMeasuredWidth()/20,p);
    }
}
