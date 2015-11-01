package com.zen.android.eroid.inject;

import com.zen.android.eroid.inject.component.IDroidComponent;

/**
 * DroidComponentManager
 *
 * @author zeny
 * @version 2015.10.25
 */
public final class DroidComponentManager {

    private static IDroidComponent sAppComponent;

    private DroidComponentManager() {
    }

    public static void init(IDroidComponent component) {
        sAppComponent = component;
    }

    public static IDroidComponent get() {
        return sAppComponent;
    }
}
