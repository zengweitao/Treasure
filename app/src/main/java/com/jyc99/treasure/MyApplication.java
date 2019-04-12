package com.jyc99.treasure;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.jyc99.treasure.base.MyLifecycleHandler;

/**
 * Created by zeng on 2019/4/9.
 */
public class MyApplication extends Application {
    private static Context context;
    public static MyApplication instance;
    private int activityCount = 0;//activity的count数
    private boolean isForeground = true;//是否在前台

    public static MyApplication getInstance() {
        return instance;
    }

    public static MyApplication getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = (MyApplication) getApplicationContext();
        context = (MyApplication) getApplicationContext();

        registerActivityLifecycleCallbacks(new MyLifecycleHandler());
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {
                activityCount++;
                if (activityCount > 0) {
                    isForeground = true;
                }
            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {
                activityCount--;
                if (0 == activityCount) {
                    isForeground = false;
                }
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    private void showToast(final String text) {

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
