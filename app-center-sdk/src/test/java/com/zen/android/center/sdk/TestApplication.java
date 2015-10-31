package com.zen.android.center.sdk;

import android.app.Application;

import com.zen.android.center.sdk.inject.DaggerTestCenterComponent;
import com.zen.android.center.sdk.inject.component.CenterComponent;

/**
 * TestApplication
 *
 * @author zeny
 * @version 2015.10.29
 */
public class TestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AppCenter.init();
        CenterComponent.Instance.init(DaggerTestCenterComponent.builder().build());
    }
}
