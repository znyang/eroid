package com.zen.android.eroid.ui;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.zen.android.eroid.ui.page.DroidPageDelegate;

import rx.Subscription;

/**
 * DroidFragment
 *
 * @author zeny
 * @version 2015.10.24
 */
public class DroidFragment extends Fragment {

    private DroidPageDelegate<DroidFragment> mDroidPageDelegate;

    public void collect(Subscription subscription) {
        getDroidPageDelegate().collect(subscription);
    }

    @NonNull
    public DroidPageDelegate<DroidFragment> getDroidPageDelegate() {
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
