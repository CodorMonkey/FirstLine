package com.monkey.firstline.common;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MonkeyKiky on 2016/1/7.
 */
public class ActivityCollector {
    private static List<Activity> activities = new ArrayList<>();

    public static void add(Activity activity) {
        activities.add(activity);
    }

    public static void remove(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity :
                activities) {
            if (activity != null && !activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
