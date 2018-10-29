package com.lq.testlayoutinflate;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by lq on 2018/10/29.
 */

public class TtileView extends FrameLayout {
    private Button leftButton;
    private TextView titleText;

    public TtileView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //这里会执行titleview.addView(title)
        LayoutInflater.from(context).inflate(R.layout.title,this);
        titleText = findViewById(R.id.title_text);
        leftButton = findViewById(R.id.button_left);
        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
    }
    //修改title文本
    public void setTitleText(String text){
        titleText.setText(text);
    }
    //修改按钮文本
    public void setLeftButtonText(String text){
        leftButton.setText(text);
    }
    public void setLeftButtonListener(OnClickListener l){
        leftButton.setOnClickListener(l);
    }
}
