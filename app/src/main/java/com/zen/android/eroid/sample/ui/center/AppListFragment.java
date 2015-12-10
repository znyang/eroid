package com.zen.android.eroid.sample.ui.center;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.srx.widget.PullCallback;
import com.srx.widget.PullToLoadView;
import com.zen.android.center.sdk.model.App;
import com.zen.android.eroid.sample.R;
import com.zen.android.eroid.sample.ui.base.BaseLayoutFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

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

    private ListAdapter mListAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_center;
    }

    @Override
    public void onStart() {
        super.onStart();

        mPullToLoadView.getRecyclerView().setLayoutManager(
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mListAdapter = new ListAdapter();
        mPullToLoadView.getRecyclerView().setAdapter(mListAdapter);

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
//        mPullToLoadView.initLoad();
    }


    private void doRefresh(int currentCount) {
        Subscription subscription = getAppCenter()
                .getAppList(currentCount, PAGE_SIZE).first()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                            updateData(currentCount, result);
                        },
                        throwable -> {
                            mPullToLoadView.setComplete();
                            showMessage(throwable.getMessage());
                        },
                        () -> mPullToLoadView.setComplete());
        collect(subscription);
    }

    private void showMessage(CharSequence message) {
        if (getView() == null) {
            return;
        }
        Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
    }

    private void updateData(int start, List<App> data) {
        if (mListAdapter == null) {
            return;
        }
        List<App> target = mListAdapter.getData();
        if (target == null) {
            target = new ArrayList<>();
        }
        if (target.size() < start) {
            return;
        }
        target.remove(start);
        target.addAll(start, data);

        mListAdapter.setData(target);
        mListAdapter.notifyDataSetChanged();
    }

    private static class ListAdapter extends RecyclerView.Adapter<ViewHolder> {

        private List<App> mData;

        public void setData(List<App> data) {
            mData = data;
        }

        public List<App> getData() {
            return mData;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_app, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.populateView(mData.get(position));
        }

        @Override
        public int getItemCount() {
            return mData == null ? 0 : mData.size();
        }
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvAppName;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvAppName = (TextView) itemView.findViewById(R.id.tv_app_name);
        }

        private void populateView(App app) {
            mTvAppName.setText(app.getAppName());
        }
    }
}
