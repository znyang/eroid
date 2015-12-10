package com.zen.android.center.sdk.store;

import com.zen.android.center.sdk.injection.component.CenterComponent;
import com.zen.android.center.sdk.protocol.ClientApi;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * CenterStoreHelper
 *
 * @author zeny
 * @version 2015.12.06
 */
public class CenterStoreHelper {

    @Inject
    ClientApi mClientApi;

    public CenterStoreHelper() {
        CenterComponent.Instance.get().inject(this);
    }

    public ClientApi getClientApi() {
        return mClientApi;
    }

}
