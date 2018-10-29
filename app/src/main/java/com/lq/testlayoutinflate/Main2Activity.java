package com.lq.testlayoutinflate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private MyListView myListView;
    private MyAdapter adapter;
    private List<String> contentList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        //父linear
//        LinearLayout mainLinear = findViewById(R.id.main_linear);
//        //要添加的view
//        View view = LayoutInflater.from(Main2Activity.this).inflate(R.layout.root_test_linear,
//                (ViewGroup) findViewById(R.id.root_linear));
//        mainLinear.addView(view);

        initList();
        myListView = findViewById(R.id.my_list_view);
        myListView.setOnDeleteListener(new MyListView.OnDeleteListener() {
            @Override
            public void onDelete(int index) {
                contentList.remove(index);
                adapter.notifyDataSetChanged();
            }
        });
        adapter = new MyAdapter(this, 0, contentList);
        myListView.setAdapter(adapter);

    }

    private void initList(){
        for(int i=0;i<20;i++){
            contentList.add("Content Item "+(i+1));
        }
    }
}
