package com.zen.android.eroid.sample.ui.base;

import com.zen.android.eroid.sample.injection.InjectManager;
import com.zen.android.eroid.ui.DroidActivity;
import com.zen.android.weather.protocol.WeatherApi;

import javax.inject.Inject;

/**
 * BaseActivity
 *
 * @author zeny
 * @version 2015.10.24
 */
public abstract class BaseActivity extends DroidActivity {

    @Inject
    WeatherApi mAppCenterApi;

    public BaseActivity() {
        InjectManager.getComponent().inject(this);
    }

    public WeatherApi getAppCenter() {
        return mAppCenterApi;
    }
}
