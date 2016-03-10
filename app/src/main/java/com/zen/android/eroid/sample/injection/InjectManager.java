package com.zen.android.eroid.sample.injection;

import android.support.annotation.NonNull;

/**
 * InjectManager
 * <p>
 *
 * @author zeny
 * @version 2015/11/5
 */
public class InjectManager {

    private static AppComponent sComponent;

    public static void init(@NonNull AppComponent component) {
        sComponent = component;
    }

    public static AppComponent getComponent() {
        if (sComponent == null) {
            sComponent = DaggerIProAppComponent.builder().build();
        }
        return sComponent;
    }
}
