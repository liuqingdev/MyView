package com.lq.testlayoutinflate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lq on 2018/10/29.
 */

public class MyAdapter extends ArrayAdapter<String> {
    public MyAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("adapter","getview");
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.my_list_view_item,null);
        }
        TextView textView = convertView.findViewById(R.id.text_view);
        textView.setText(getItem(position));
        return convertView;
    }
}
