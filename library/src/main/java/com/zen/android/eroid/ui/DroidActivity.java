package com.zen.android.eroid.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.zen.android.eroid.rx.lifecycle.ActivityEvent;
import com.zen.android.eroid.rx.util.SchedulerCompat;
import com.zen.android.eroid.injection.DroidComponentManager;
import com.zen.android.eroid.rx.support.RxAppCompatActivity;
import com.zen.android.eroid.ui.page.DroidPageDelegate;

import rx.Observable;
import rx.Subscription;

/**
 * DroidActivity
 *
 * @author zeny
 * @version 2015.10.24
 */
public class DroidActivity extends RxAppCompatActivity {

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

    public <T> Observable.Transformer<T, T> async() {
        return obs -> obs.compose(bindUntilEvent(ActivityEvent.STOP))
                .compose(SchedulerCompat.applyIoSchedulers());
    }

}
