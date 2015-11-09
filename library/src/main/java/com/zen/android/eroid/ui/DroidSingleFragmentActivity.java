package com.zen.android.eroid.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * DroidSingleFragmentActivity
 *
 * @author zeny
 * @version 2015.11.09
 */
public abstract class DroidSingleFragmentActivity<F extends Fragment> extends DroidActivity {

    protected FrameLayout mContainer;
    protected F           mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createDefaultContainer();
        onCreateSingleFragment(savedInstanceState);
    }

    @SuppressWarnings("unchecked")
    protected void onCreateSingleFragment(Bundle data) {
        mFragment = (F) getSupportFragmentManager().findFragmentByTag(getFragmentTag());
        if (mFragment == null) {
            mFragment = buildFragment();
        }
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, mFragment, getFragmentTag())
                .commit();
    }

    protected void createDefaultContainer() {
        FrameLayout container = new FrameLayout(this);
        container.setId(android.R.id.content);
        setContentView(container, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        mContainer = container;
    }

    protected abstract F buildFragment();

    protected String getFragmentTag() {
        return "_single";
    }
}
