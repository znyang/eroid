package com.zen.android.eroid.ui.page;

import android.app.Activity;

import com.zen.android.eroid.ui.base.ISubscribe;

import rx.Subscription;
import rx.internal.util.SubscriptionList;

/**
 * DroidPageDelegate
 *
 * @author zeny
 * @version 2015.10.24
 */
public class DroidPageDelegate<T> implements ISubscribe {

    private SubscriptionList mSubscriptionList = new SubscriptionList();

    private final T mHost;

    private DroidPageDelegate(T host) {
        mHost = host;
    }

    public static <T> DroidPageDelegate<T> create(T host) {
        return new DroidPageDelegate<>(host);
    }

    @Override
    public void collect(Subscription obs) {
        mSubscriptionList.add(obs);
    }

    @Override
    public void unsubscribe() {
        mSubscriptionList.unsubscribe();
    }

    public void register(Activity activity) {
        PageManager.getInstance().add(activity);
    }

}
