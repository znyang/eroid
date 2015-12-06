package com.zen.android.center.sdk.store.base;

import io.realm.Realm;

/**
 * RealmTask
 *
 * @author zeny
 * @version 2015.12.06
 */
public interface RealmTask<T> {

    T execute(Realm realm);

}
