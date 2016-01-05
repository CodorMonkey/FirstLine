package com.monkey.firstline.unit4.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.monkey.firstline.R;
import com.monkey.firstline.unit4.fragment.NewsContentFragment;

public class NewsContentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_news_content);
        Bundle extras = getIntent().getExtras();
        String newsTitle = extras.getString("news_title");
        String newsContent = extras.getString("news_content");
        NewsContentFragment contentFragment = (NewsContentFragment) getFragmentManager()
                .findFragmentById(R.id.frg_news_content);
        contentFragment.refresh(newsTitle, newsContent);
    }

    public static void actionStart(Context context, String title, String content) {
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("news_title", title);
        intent.putExtra("news_content", content);
        context.startActivity(intent);
    }
}
