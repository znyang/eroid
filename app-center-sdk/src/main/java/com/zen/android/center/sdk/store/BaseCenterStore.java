package com.zen.android.center.sdk.store;

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

    private CenterStoreHelper mCenterStoreHelper = new CenterStoreHelper();

    protected ClientApi getClientApi() {
        return mCenterStoreHelper.getClientApi();
    }

    public Observable<T> concat() {
        return Observable.concat(disk(), network());
    }

    public Observable<T> fetch(boolean isRefresh) {
        return isRefresh ? concat().last() : concat().first();
    }

    public static <T> T task(RealmTask<T> task) {
        Realm realm = Realm.getDefaultInstance();
        try {
            return task.execute(realm);
        } finally {
            realm.close();
        }
    }

    public static void taskVoid(RealmVoidTask task) {
        Realm realm = Realm.getDefaultInstance();
        try {
            task.execute(realm);
        } finally {
            realm.close();
        }
    }

}
