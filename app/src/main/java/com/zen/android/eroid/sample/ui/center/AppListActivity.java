package com.zen.android.eroid.sample.ui.center;

import com.zen.android.eroid.sample.ui.base.BaseSingleFragmentActivity;

/**
 * AppListActivity
 *
 * @author zeny
 * @version 2015.11.09
 */
public class AppListActivity extends BaseSingleFragmentActivity<AppListFragment> {
    @Override
    protected AppListFragment buildFragment() {
        return new AppListFragment();
    }


}
