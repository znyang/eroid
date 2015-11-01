package com.zen.android.eroid.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.zen.android.eroid.inject.DroidComponentManager;
import com.zen.android.eroid.ui.page.DroidPageDelegate;

import rx.Subscription;

/**
 * DroidActivity
 *
 * @author zeny
 * @version 2015.10.24
 */
public class DroidActivity extends AppCompatActivity {

    private DroidPageDelegate<DroidActivity> mDroidPageDelegate;

    public DroidActivity() {
        DroidComponentManager.get().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDroidPageDelegate().register(this);
    }

    @NonNull
    public DroidPageDelegate<DroidActivity> getDroidPageDelegate() {
        if (mDroidPageDelegate == null) {
            mDroidPageDelegate = DroidPageDelegate.create(this);
        }
        return mDroidPageDelegate;
    }

    public void collect(Subscription obs) {
        getDroidPageDelegate().collect(obs);
    }

    @Override
    protected void onStop() {
        super.onStop();
        getDroidPageDelegate().unsubscribe();
    }
}
