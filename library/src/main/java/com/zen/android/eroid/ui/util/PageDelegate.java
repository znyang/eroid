package com.zen.android.eroid.ui.util;

import android.app.Activity;

import rx.Subscription;
import rx.internal.util.SubscriptionList;

/**
 * PageDelegate
 *
 * @author zeny
 * @version 2015.10.24
 */
public class PageDelegate implements ISubscribeHandle {

    private SubscriptionList mSubscriptionList = new SubscriptionList();

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
