package com.zen.android.eroid.ui.util;

import android.app.Activity;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Set;

import rx.Observable;

/**
 * PageManager
 *
 * @author zeny
 * @version 2015.10.24
 */
public class PageManager {

    private static final PageManager INSTANCE = new PageManager();

    public static PageManager getInstance() {
        return INSTANCE;
    }

    private Set<WeakReference<Activity>> collection
            = new LinkedHashSet<>();

    public void add(Activity activity) {
        collection.add(new WeakReference<>(activity));
    }

    public void clear() {
        Observable.from(collection)
                .filter(ref -> ref != null && ref.get() != null)
                .map(Reference::get)
                .subscribe(Activity::finish);
        collection.clear();
    }

    public void clearExcept(final Class<? extends Activity> clazz) {
        Observable.from(collection)
                .filter(ref -> {
                    if (ref == null) {
                        return false;
                    }
                    Activity activity = ref.get();
                    return activity != null && !activity.getClass().equals(clazz);
                })
                .map(Reference::get)
                .subscribe(Activity::finish);
    }

}
