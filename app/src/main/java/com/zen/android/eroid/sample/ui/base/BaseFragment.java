package com.zen.android.eroid.sample.ui.base;

import com.zen.android.center.sdk.AppCenterApi;
import com.zen.android.center.sdk.protocol.ClientApi;
import com.zen.android.eroid.sample.injection.InjectManager;
import com.zen.android.eroid.ui.DroidFragment;

import javax.inject.Inject;

/**
 * BaseFragment
 *
 * @author zeny
 * @version 2015.10.24
 */
public abstract class BaseFragment extends DroidFragment {

    @Inject
    AppCenterApi mAppCenterApi;

    public BaseFragment() {
        InjectManager.getComponent().inject(this);
    }

    public AppCenterApi getAppCenter() {
        return mAppCenterApi;
    }

}
