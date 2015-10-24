package com.zen.android.eroid;

import android.app.Application;
import android.content.Context;
import android.os.Process;

import com.zen.android.eroid.base.ContextUtil;
import com.zen.android.eroid.ui.util.PageManager;

/**
 * DroidApp
 *
 * @author zeny
 * @version 2015.10.24
 */
public class DroidApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ContextUtil.setAppContext(this);
    }

    protected void beforeExit() {
        PageManager.getInstance().clear();
    }

    public static void exit() {
        Context context = ContextUtil.getAppContext();
        if (context instanceof DroidApp) {
            ((DroidApp) context).beforeExit();
        }

        android.os.Process.killProcess(Process.myPid());
        System.exit(0);
    }
}
