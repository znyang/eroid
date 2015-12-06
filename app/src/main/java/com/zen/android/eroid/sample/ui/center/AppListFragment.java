package com.zen.android.eroid.sample.ui.center;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.marshalchen.ultimaterecyclerview.CustomLinearLayoutManager;
import com.srx.widget.PullCallback;
import com.srx.widget.PullToLoadView;
import com.zen.android.center.sdk.model.App;
import com.zen.android.eroid.sample.R;
import com.zen.android.eroid.sample.ui.base.BaseLayoutFragment;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import rx.Subscription;

/**
 * AppListFragment
 * <p>
 *
 * @author zeny
 * @version 2015/11/5
 */
public class AppListFragment extends BaseLayoutFragment {

    private static final int PAGE_SIZE = 10;

    @InjectView(R.id.plv_center)
    PullToLoadView mPullToLoadView;

    private List<App> mData;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_center;
    }

    @Override
    public void onStart() {
        super.onStart();

        mPullToLoadView.isLoadMoreEnabled(true);
        mPullToLoadView.setPullCallback(new PullCallback() {
            @Override
            public void onLoadMore() {

            }

            @Override
            public void onRefresh() {
                doRefresh(0);
            }

            @Override
            public boolean isLoading() {
                return false;
            }

            @Override
            public boolean hasLoadedAllItems() {
                return false;
            }
        });
    }


    private void doRefresh(int currentCount) {
        Subscription subscription = getAppCenter().getAppList(currentCount, PAGE_SIZE).first()
                .subscribe(result -> {
                    updateData(currentCount, result);
                });
        collect(subscription);
    }

    private void updateData(int start, List<App> data) {
        if (mData == null) {
            mData = new ArrayList<>();
        }
        if (mData.size() < start) {
            return;
        }
        mData.addAll(start, data);
    }
}
