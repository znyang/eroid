package com.zen.android.eroid.ui.page;

import android.app.Activity;

/**
 * DroidPageDelegate
 *
 * @author zeny
 * @version 2015.10.24
 */
public class DroidPageDelegate<T> {

    private final T mHost;

    private DroidPageDelegate(T host) {
        mHost = host;
    }

    public static <T> DroidPageDelegate<T> create(T host) {
        return new DroidPageDelegate<>(host);
    }

    public void register(Activity activity) {
        PageManager.getInstance().add(activity);
    }

}
