package com.zen.android.eroid.ui;

import android.support.annotation.NonNull;

import com.zen.android.eroid.rx.lifecycle.FragmentEvent;
import com.zen.android.eroid.rx.support.RxDialogFragment;
import com.zen.android.eroid.rx.util.SchedulerCompat;
import com.zen.android.eroid.ui.page.DroidPageDelegate;

import rx.Observable;

/**
 * DroidDialogFragment
 *
 * @author zeny
 * @version 2015.10.25
 */
public class DroidDialogFragment extends RxDialogFragment {

    private DroidPageDelegate<DroidDialogFragment> mDroidPageDelegate;

    @NonNull
    public DroidPageDelegate<DroidDialogFragment> getDroidPageDelegate() {
        if (mDroidPageDelegate == null) {
            mDroidPageDelegate = DroidPageDelegate.create(this);
        }
        return mDroidPageDelegate;
    }

    public <T> Observable.Transformer<T, T> async() {
        return obs -> obs.compose(bindUntilEvent(FragmentEvent.STOP))
                .compose(SchedulerCompat.applyIoSchedulers());
    }

}
