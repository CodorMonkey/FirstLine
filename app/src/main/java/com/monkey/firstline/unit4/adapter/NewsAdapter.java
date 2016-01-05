package com.monkey.firstline.unit4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.monkey.firstline.R;
import com.monkey.firstline.unit4.entity.News;

import java.util.List;

/**
 * Created by MonkeyKiky on 2016/1/5.
 */
public class NewsAdapter extends ArrayAdapter<News> {
    private int resource;

    public NewsAdapter(Context context, int resource, List<News> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resource, null);
        }
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_news_title);
        tvTitle.setText(getItem(position).getTitle());
        return convertView;
    }
}
