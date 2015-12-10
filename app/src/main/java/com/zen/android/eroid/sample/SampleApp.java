package com.zen.android.eroid.sample;

import com.zen.android.center.sdk.AppCenter;
import com.zen.android.eroid.DroidApp;
import com.zen.android.eroid.sample.injection.DaggerIProAppComponent;
import com.zen.android.eroid.sample.injection.InjectManager;

/**
 * SampleApp
 *
 * @author zeny
 * @version 2015.10.24
 */
public class SampleApp extends DroidApp {

    @Override
    public void onCreate() {
        super.onCreate();

        InjectManager.init(DaggerIProAppComponent.builder().build());
        AppCenter.init();
    }

    @Override
    protected void beforeExit() {
        super.beforeExit();
        AppCenter.recycle();
    }
}
