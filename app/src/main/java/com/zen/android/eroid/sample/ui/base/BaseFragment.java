package com.zen.android.eroid.sample.ui.base;

import com.zen.android.eroid.sample.injection.InjectManager;
import com.zen.android.eroid.ui.DroidFragment;
import com.zen.android.weather.protocol.WeatherApi;

import javax.inject.Inject;

/**
 * BaseFragment
 *
 * @author zeny
 * @version 2015.10.24
 */
public abstract class BaseFragment extends DroidFragment {

    @Inject
    WeatherApi mAppCenterApi;

    public BaseFragment() {
        InjectManager.getComponent().inject(this);
    }

    public WeatherApi getAppCenter() {
        return mAppCenterApi;
    }

}
