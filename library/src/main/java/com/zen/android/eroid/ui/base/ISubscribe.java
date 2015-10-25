package com.zen.android.eroid.ui.base;

import rx.Subscription;

/**
 * ISubscribe
 *
 * @author zeny
 * @version 2015.10.24
 */
public interface ISubscribe {

    void collect(Subscription obs);

    void unsubscribe();

}
