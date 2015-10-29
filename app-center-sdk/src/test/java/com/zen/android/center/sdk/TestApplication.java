package com.zen.android.center.sdk;

import android.app.Application;

/**
 * TestApplication
 *
 * @author zeny
 * @version 2015.10.29
 */
public class TestApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        AppCenter.init();
    }
}
