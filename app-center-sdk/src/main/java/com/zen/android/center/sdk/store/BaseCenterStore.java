package com.zen.android.center.sdk.store;

import com.zen.android.center.sdk.protocol.ClientApi;

import rx.Observable;

/**
 * BaseCenterStore
 *
 * @author zeny
 * @version 2015.12.06
 */
public abstract class BaseCenterStore<T> implements BaseStore<T> {

    private static CenterStoreHelper sCenterStoreHelper = new CenterStoreHelper();

    protected ClientApi getClientApi() {
        return sCenterStoreHelper.getClientApi();
    }

    public Observable<T> concat() {
        return Observable.concat(disk(), network());
    }

    public Observable<T> fetch(boolean isRefresh) {
        return isRefresh ? concat().last() : concat().first();
    }

}
