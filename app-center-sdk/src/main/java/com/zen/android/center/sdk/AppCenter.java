package com.zen.android.center.sdk;

import com.zen.android.center.sdk.injection.component.CenterComponent;
import com.zen.android.center.sdk.injection.component.DaggerProCenterComponent;

import javax.inject.Inject;

/**
 * AppCenter
 *
 * @author zeny
 * @version 2015.10.26
 */
public class AppCenter {

    @Inject
    AppCenterApi mApi;

    public AppCenter() {
        CenterComponent.Instance.get().inject(this);
    }

    public static void init() {
        CenterComponent.Instance.init(DaggerProCenterComponent.builder().build());
    }

    public static void recycle() {
    }

    public AppCenterApi getApi() {
        return mApi;
    }

}
