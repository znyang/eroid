package com.zen.android.eroid.base;

import android.content.Context;

/**
 * ContextUtil
 *
 * @author zeny
 * @version 2015.10.24
 */
public final class ContextUtil {

    private static Context sAppContext;

    private ContextUtil() {
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    public static void setAppContext(Context appContext) {
        sAppContext = appContext;
    }
}
