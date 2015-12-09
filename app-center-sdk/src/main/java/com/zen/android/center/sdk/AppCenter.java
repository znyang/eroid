package com.zen.android.center.sdk;

import com.zen.android.center.sdk.injection.component.CenterComponent;
import com.zen.android.center.sdk.injection.component.DaggerProCenterComponent;
import com.zen.android.center.sdk.protocol.ClientApi;
import com.zen.android.center.sdk.store.BaseCenterStore;
import com.zen.android.center.sdk.store.CenterStoreHelper;
import com.zen.android.eroid.base.ContextUtil;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * AppCenter
 *
 * @author zeny
 * @version 2015.10.26
 */
public class AppCenter {

    @Inject
    AppCenterApi mApi;
    @Inject
    Realm        mRealm;

    public AppCenter() {
        CenterComponent.Instance.get().inject(this);
    }

    public static void init() {
        CenterComponent.Instance.init(DaggerProCenterComponent.builder().build());
    }

    public static void recycle() {
        BaseCenterStore.onRecycle();
    }

    public AppCenterApi getApi() {
        return mApi;
    }

}
