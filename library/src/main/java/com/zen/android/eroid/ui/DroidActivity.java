package com.zen.android.eroid.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zen.android.eroid.ui.util.PageDelegate;

import rx.Subscription;

/**
 * DroidActivity
 *
 * @author zeny
 * @version 2015.10.24
 */
public class DroidActivity extends AppCompatActivity{

    private PageDelegate mPageDelegate = new PageDelegate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageDelegate.register(this);
    }

    public void collect(Subscription obs) {
        mPageDelegate.collect(obs);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPageDelegate.unsubscribe();
    }
}
