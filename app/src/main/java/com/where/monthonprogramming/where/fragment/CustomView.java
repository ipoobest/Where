package com.where.monthonprogramming.where.fragment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Ter on 11/11/2016.
 */

public class CustomView extends View {
    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(21)
    public CustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        p.setColor(0xFFFF0000);






        canvas.drawLine(getMeasuredWidth()*83/100,getMeasuredHeight()*6/100,getMeasuredWidth(),getMeasuredHeight()*20/100,p);
        canvas.drawLine(getMeasuredWidth()*78/100,getMeasuredHeight()*7/100,getMeasuredWidth()*94/100,getMeasuredHeight()*22/100,p);
        canvas.drawLine(getMeasuredWidth()*71/100,getMeasuredHeight()*9/100,getMeasuredWidth()*89/100,getMeasuredHeight()*24/100,p);
        canvas.drawLine(getMeasuredWidth()*64/100,getMeasuredHeight()*11/100,getMeasuredWidth()*84/100,getMeasuredHeight()*26/100,p);
        canvas.drawLine(getMeasuredWidth()*57/100,getMeasuredHeight()*14/100,getMeasuredWidth()*79/100,getMeasuredHeight()*29/100,p);
        canvas.drawLine(getMeasuredWidth()*51/100,getMeasuredHeight()*18/100,getMeasuredWidth()*74/100,getMeasuredHeight()*32/100,p);






        canvas.drawLine(getMeasuredWidth()*45/100,getMeasuredHeight()*24/100,getMeasuredWidth()*67/100,getMeasuredHeight()*35/100,p);
        canvas.drawLine(getMeasuredWidth()*41/100,getMeasuredHeight()*28/100,getMeasuredWidth()*63/100,getMeasuredHeight()*38/100,p);

        canvas.drawLine(getMeasuredWidth()*35/100,getMeasuredHeight()*32/100,getMeasuredWidth()*59/100,getMeasuredHeight()*41/100,p);
        canvas.drawLine(getMeasuredWidth()*31/100,getMeasuredHeight()*36/100,getMeasuredWidth()*55/100,getMeasuredHeight()*45/100,p);
        canvas.drawLine(getMeasuredWidth()*27/100,getMeasuredHeight()*39/100,getMeasuredWidth()*49/100,getMeasuredHeight()*49/100,p);
        canvas.drawLine(getMeasuredWidth()*24/100,getMeasuredHeight()*42/100,getMeasuredWidth()*47/100,getMeasuredHeight()*52/100,p);
        canvas.drawLine(getMeasuredWidth()*21/100,getMeasuredHeight()*45/100,getMeasuredWidth()*45/100,getMeasuredHeight()*55/100,p);
        canvas.drawLine(getMeasuredWidth()*18/100,getMeasuredHeight()*48/100,getMeasuredWidth()*43/100,getMeasuredHeight()*58/100,p);
        canvas.drawLine(getMeasuredWidth()*16/100,getMeasuredHeight()*51/100,getMeasuredWidth()*41/100,getMeasuredHeight()*61/100,p);
        canvas.drawLine(getMeasuredWidth()*14/100,getMeasuredHeight()*54/100,getMeasuredWidth()*39/100,getMeasuredHeight()*64/100,p);
        canvas.drawLine(getMeasuredWidth()*12/100,getMeasuredHeight()*57/100,getMeasuredWidth()*37/100,getMeasuredHeight()*67/100,p);
        canvas.drawLine(getMeasuredWidth()*11/100,getMeasuredHeight()*60/100,getMeasuredWidth()*35/100,getMeasuredHeight()*70/100,p);
        canvas.drawLine(getMeasuredWidth()*10/100,getMeasuredHeight()*63/100,getMeasuredWidth()*34/100,getMeasuredHeight()*73/100,p);
        canvas.drawLine(getMeasuredWidth()*7/100,getMeasuredHeight()*69/100,getMeasuredWidth()*32/100,getMeasuredHeight()*79/100,p);
        canvas.drawLine(getMeasuredWidth()*5/100,getMeasuredHeight()*72/100,getMeasuredWidth()*31/100,getMeasuredHeight()*82/100,p);
        canvas.drawLine(getMeasuredWidth()*3/100,getMeasuredHeight()*75/100,getMeasuredWidth()*29/100,getMeasuredHeight()*85/100,p);
        canvas.drawLine(0,getMeasuredHeight()*81/100,getMeasuredWidth()*1/4,getMeasuredHeight()*91/100,p);
        canvas.drawLine(0,getMeasuredHeight()*86/100,getMeasuredWidth()*1/4,getMeasuredHeight()*95/100,p);

        canvas.drawLine(0,getMeasuredHeight()*90/100,getMeasuredWidth()*1/4,getMeasuredHeight(),p);
//asdasdas

    }




}
