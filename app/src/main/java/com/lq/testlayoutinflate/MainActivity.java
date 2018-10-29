package com.lq.testlayoutinflate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<String> list = new ArrayList<>();
    private MainActivity context = this;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.add("张三");
        list.add("李四");
        list.add("王五");
        listView = findViewById(R.id.listview);
        adapter = new MyAdapter();
        listView.setAdapter(adapter);
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null){
                //parent 指的是listview
                convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            }
            TextView tv = convertView.findViewById(R.id.text);
            String name = list.get(position);
            tv.setText(name);
            return convertView;
        }
    }
}
