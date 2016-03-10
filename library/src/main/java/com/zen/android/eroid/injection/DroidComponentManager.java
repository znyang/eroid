package com.zen.android.eroid.injection;

import com.zen.android.eroid.injection.component.DaggerIProDroidComponent;
import com.zen.android.eroid.injection.component.IDroidComponent;

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

    public static IDroidComponent get() {
        if (sAppComponent == null) {
            sAppComponent = DaggerIProDroidComponent.builder().build();
        }
        return sAppComponent;
    }
}
