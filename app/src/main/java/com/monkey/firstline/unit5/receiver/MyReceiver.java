package com.monkey.firstline.unit5.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by MonkeyKiky on 2016/1/7.
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "My receiver", Toast.LENGTH_SHORT).show();
        abortBroadcast();
    }
}
