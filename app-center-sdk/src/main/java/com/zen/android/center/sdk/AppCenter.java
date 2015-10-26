package com.zen.android.center.sdk;

import com.zen.android.center.sdk.inject.component.CenterComponent;
import com.zen.android.center.sdk.protocol.ClientApi;

import javax.inject.Inject;

/**
 * AppCenter
 *
 * @author zeny
 * @version 2015.10.26
 */
public class AppCenter {

    @Inject
    private ClientApi mApi;

    public AppCenter() {
        CenterComponent.Instance.get().inject(this);
    }

    public static ClientApi client() {
        return new AppCenter().mApi;
    }

}
