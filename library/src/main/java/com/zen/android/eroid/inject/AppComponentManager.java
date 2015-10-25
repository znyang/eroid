package com.zen.android.eroid.inject;

import com.zen.android.eroid.inject.component.IDroidAppComponent;

/**
 * AppComponentManager
 *
 * @author zeny
 * @version 2015.10.25
 */
public final class AppComponentManager {

    private static IDroidAppComponent sAppComponent;

    private AppComponentManager() {
    }

    public static void init(IDroidAppComponent component) {
        sAppComponent = component;
    }

    public static IDroidAppComponent get() {
        return sAppComponent;
    }
}
