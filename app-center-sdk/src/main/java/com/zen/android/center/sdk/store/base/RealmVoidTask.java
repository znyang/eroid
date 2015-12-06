package com.zen.android.center.sdk.store.base;

import io.realm.Realm;

/**
 * RealmVoidTask
 *
 * @author zeny
 * @version 2015.12.06
 */
public interface RealmVoidTask {
    void execute(Realm realm);
}
