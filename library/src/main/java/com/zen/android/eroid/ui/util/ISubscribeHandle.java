package com.zen.android.eroid.ui.util;

import rx.Subscription;

/**
 * ISubscribeHandle
 *
 * @author zeny
 * @version 2015.10.24
 */
public interface ISubscribeHandle {

    void collect(Subscription obs);

    void unsubscribe();

}
