package com.zen.android.eroid.sample.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * BaseLayoutFragment
 *
 * @author zeny
 * @version 2015.11.09
 */
public abstract class BaseLayoutFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.inject(this, root);
        return root;
    }

    protected abstract int getLayoutId();
}
