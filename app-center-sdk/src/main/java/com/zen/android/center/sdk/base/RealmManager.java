package com.zen.android.center.sdk.base;

import com.zen.android.eroid.base.ContextUtil;

import java.util.HashSet;
import java.util.Set;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import rx.Observable;

/**
 * RealmManager
 *
 * @author zeny
 * @version 2015.12.10
 */
public class RealmManager {

    private static Set<Realm> sRealmSet = new HashSet<>();

    public static void init() {
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder(ContextUtil.getAppContext()).build());
    }

    public static Realm getRealm() {
        Realm realm = Realm.getDefaultInstance();
        if (!sRealmSet.contains(realm)) {
            sRealmSet.add(realm);
        }
        return realm;
    }

    public static void recycle() {
        Observable.from(sRealmSet)
                .filter(realm -> realm != null)
                .subscribe(Realm::close);
    }

}
