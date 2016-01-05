package com.monkey.firstline.unit4;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.monkey.firstline.R;
import com.monkey.firstline.unit4.activity.NewsActivity;
import com.monkey.firstline.unit4.fragment.Right2Fragment;

public class Unit4Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_unit4);
        Button btnLeftFrg = (Button) findViewById(R.id.btn_left_fragment);
        btnLeftFrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                Fragment fragment = new Right2Fragment();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fl_right, fragment);
                // 设置后，点击返回键会回到替换前的fragment，而不是退出activity
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        Button btnShowNews = (Button) findViewById(R.id.btn_show_news);
        btnShowNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), NewsActivity.class);
                startActivity(intent);
            }
        });
    }
}