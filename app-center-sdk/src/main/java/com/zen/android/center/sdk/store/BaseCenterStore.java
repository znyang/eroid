package com.zen.android.center.sdk.store;

import com.zen.android.center.sdk.base.RealmManager;
import com.zen.android.center.sdk.protocol.ClientApi;
import com.zen.android.center.sdk.store.base.RealmTask;
import com.zen.android.center.sdk.store.base.RealmVoidTask;

import io.realm.Realm;
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

    protected Realm getRealm() {
        return RealmManager.getRealm();
    }

    public Observable<T> concat() {
        return Observable.concat(disk(), network());
    }

    public Observable<T> fetch(boolean isRefresh) {
        return isRefresh ? concat().last() : concat().first();
    }

}
