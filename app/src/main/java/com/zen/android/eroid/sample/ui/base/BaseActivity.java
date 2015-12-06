package com.zen.android.eroid.sample.ui.base;

import com.zen.android.center.sdk.AppCenterApi;
import com.zen.android.center.sdk.protocol.ClientApi;
import com.zen.android.eroid.sample.injection.InjectManager;
import com.zen.android.eroid.ui.DroidActivity;

import javax.inject.Inject;

/**
 * BaseActivity
 *
 * @author zeny
 * @version 2015.10.24
 */
public abstract class BaseActivity extends DroidActivity {

    @Inject
    AppCenterApi mAppCenterApi;

    public BaseActivity() {
        InjectManager.getComponent().inject(this);
    }

    public AppCenterApi getAppCenter() {
        return mAppCenterApi;
    }
}
