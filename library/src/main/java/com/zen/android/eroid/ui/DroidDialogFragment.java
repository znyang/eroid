package com.zen.android.eroid.ui;

import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import com.zen.android.eroid.ui.page.DroidPageDelegate;

import rx.Subscription;

/**
 * DroidDialogFragment
 *
 * @author zeny
 * @version 2015.10.25
 */
public class DroidDialogFragment extends DialogFragment {

    private DroidPageDelegate<DroidDialogFragment> mDroidPageDelegate;

    public void collect(Subscription subscription) {
        getDroidPageDelegate().collect(subscription);
    }

    @NonNull
    public DroidPageDelegate<DroidDialogFragment> getDroidPageDelegate() {
        if (mDroidPageDelegate == null) {
            mDroidPageDelegate = DroidPageDelegate.create(this);
        }
        return mDroidPageDelegate;
    }

    @Override
    public void onStop() {
        super.onStop();
        getDroidPageDelegate().unsubscribe();
    }

}
