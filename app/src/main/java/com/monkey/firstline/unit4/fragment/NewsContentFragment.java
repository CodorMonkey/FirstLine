package com.monkey.firstline.unit4.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.monkey.firstline.R;

/**
 * Created by MonkeyKiky on 2016/1/5.
 */
public class NewsContentFragment extends Fragment {
    private LinearLayout mLlContent;
    private TextView mTvTitle;
    private TextView mTvContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_content, container, false);
        mLlContent = (LinearLayout) view.findViewById(R.id.ll_news_content);
        mTvTitle = (TextView) view.findViewById(R.id.tv_content_title);
        mTvContent = (TextView) view.findViewById(R.id.tv_news_content);
        return view;
    }

    public void refresh(String title, String content) {
        mLlContent.setVisibility(View.VISIBLE);
        mTvTitle.setText(title);
        mTvContent.setText(content);
    }
}
