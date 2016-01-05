package com.monkey.firstline.unit3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.monkey.firstline.R;
import com.monkey.firstline.unit3.entity.Message;

import java.util.List;

/**
 * Created by MonkeyKiky on 2016/1/3.
 */
public class MessageAdapter extends ArrayAdapter<Message> {
    private int resource;

    public MessageAdapter(Context context, int resource, List<Message> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message msg = getItem(position);
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(resource, null);
            holder = new ViewHolder();
            holder.llLeft = (LinearLayout) convertView.findViewById(R.id.ll_message_left);
            holder.llRight = (LinearLayout) convertView.findViewById(R.id.ll_message_right);
            holder.tvLeft = (TextView) convertView.findViewById(R.id.tv_message_left);
            holder.tvRight = (TextView) convertView.findViewById(R.id.tv_message_right);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        int msgType = msg.getType();
        String content = msg.getContent();
        if (msgType == Message.TYPE_RECEIVED) {
            holder.llRight.setVisibility(View.GONE);
            holder.llLeft.setVisibility(View.VISIBLE);
            holder.tvLeft.setText(content);
        } else if (msgType == Message.TYPE_SENT) {
            holder.llLeft.setVisibility(View.GONE);
            holder.llRight.setVisibility(View.VISIBLE);
            holder.tvRight.setText(content);
        }
        return convertView;
    }

    private class ViewHolder {
        LinearLayout llLeft;
        LinearLayout llRight;
        TextView tvLeft;
        TextView tvRight;
    }
}
