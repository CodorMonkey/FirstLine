package com.monkey.firstline.common;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by MonkeyKiky on 2016/1/7.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.add(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remove(this);
    }
}
