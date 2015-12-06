package com.zen.android.center.sdk.store;

import rx.Observable;

/**
 * BaseStore
 *
 * @author zeny
 * @version 2015.12.06
 */
public interface BaseStore<T> {

    Observable<T> disk();

    Observable<T> network();

}
