package com.lq.testlayoutinflate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lq on 2018/10/29.
 * 自绘控件
 */

public class CounterView extends View implements View.OnClickListener {
    private Paint mPaint;
    private Rect mBounds;
    private int mCount;


    public CounterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //初始化创建一个画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //创建一个矩形
        mBounds = new Rect();
        //给自身设置点击事件
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //将画笔设置为蓝色
        mPaint.setColor(Color.BLUE);
        //在画布上画一个矩形
        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);
        //将画笔设置为黄色
        mPaint.setColor(Color.GREEN);
        //将画笔设置为画文字大小为30
        mPaint.setTextSize(30);
        String text = String.valueOf(mCount);
        //获取文字内容的所占的矩形区域
        mPaint.getTextBounds(text,0,text.length(),mBounds);
        float textWidth = mBounds.width();
        float textHeight = mBounds.height();
        canvas.drawText(text,getWidth()/2-textWidth/2,getHeight()/2
            +textHeight/2,mPaint);

    }

    @Override
    public void onClick(View v) {
        mCount++;
        invalidate();
    }
}
