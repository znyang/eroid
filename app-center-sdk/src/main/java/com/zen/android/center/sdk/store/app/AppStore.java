package com.zen.android.center.sdk.store.app;

import com.zen.android.center.sdk.model.App;
import com.zen.android.center.sdk.model.RowEntry;
import com.zen.android.center.sdk.store.BaseCenterStore;

import java.util.List;

import rx.Observable;

/**
 * AppStore
 *
 * @author zeny
 * @version 2015.12.06
 */
public class AppStore extends BaseCenterStore<List<App>> {

    private int mSkip;
    private int mLimit;

    public AppStore(int skip, int limit) {
        mLimit = limit;
        mSkip = skip;
    }

    @Override
    public Observable<List<App>> disk() {
        return Observable.create(subscriber -> {
            List<App> data = query();
            if (!data.isEmpty()) {
                subscriber.onNext(data);
            }
            subscriber.onCompleted();
        });
    }

    @Override
    public Observable<List<App>> network() {
        return getClientApi().getAppList(mSkip, mLimit)
                .map(RowEntry::getResults)
                .doOnNext(this::saveToDisk);
    }

    private void saveToDisk(List<App> data) {

    }

    @SuppressWarnings("unchecked")
    private List<App> query() {
        return null;
    }

}
