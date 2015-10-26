package com.zen.android.eroid.ui.page;

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
public final class PageManager {

    private static final PageManager INSTANCE = new PageManager();

    private Set<WeakReference<Activity>> mReferences
            = new LinkedHashSet<>();

    private PageManager() {
    }

    /**
     * get single PageManager instance
     *
     * @return
     */
    public static PageManager getInstance() {
        return INSTANCE;
    }

    /**
     * register activity to collection by weak reference
     *
     * @param activity
     */
    public void add(Activity activity) {
        mReferences.add(new WeakReference<>(activity));
    }

    /**
     * clear all activity reference, execute finish()
     */
    public void clear() {
        Observable.from(mReferences)
                .filter(ref -> ref != null && ref.get() != null)
                .map(Reference::get)
                .subscribe(Activity::finish);
        mReferences.clear();
    }

    /**
     * finish all Activity if exist. except clazz
     *
     * @param clazz
     */
    public void clearExcept(final Class<? extends Activity> clazz) {
        Observable.from(mReferences)
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
