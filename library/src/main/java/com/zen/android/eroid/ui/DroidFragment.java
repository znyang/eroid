package com.zen.android.eroid.ui;

import android.support.v4.app.Fragment;

import com.zen.android.eroid.ui.util.PageDelegate;

import rx.Subscription;

/**
 * DroidFragment
 *
 * @author zeny
 * @version 2015.10.24
 */
public class DroidFragment extends Fragment {

    private PageDelegate mPageDelegate = new PageDelegate();

    public void collect(Subscription subscription) {
        mPageDelegate.collect(subscription);
    }

    @Override
    public void onStop() {
        super.onStop();
        mPageDelegate.unsubscribe();
    }

}
