package com.zen.android.eroid.sample.ui.center;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.srx.widget.PullCallback;
import com.srx.widget.PullToLoadView;
import com.zen.android.eroid.sample.R;
import com.zen.android.eroid.sample.ui.base.BaseLayoutFragment;
import com.zen.android.weather.WeatherClient;
import com.zen.android.weather.model.City;
import com.zen.android.weather.protocol.BaseEntry;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

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
        mPullToLoadView.setColorSchemeResources(R.color.colorPrimary);

        mPullToLoadView.isLoadMoreEnabled(true);
        mPullToLoadView.setPullCallback(new PullCallback() {
            @Override
            public void onLoadMore() {
                if (mListAdapter == null) {
                    return;
                }
                doRefresh(mListAdapter.getItemCount());
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
        WeatherClient.getWeatherApi().getCityList("福州")
                .compose(async())
                .map(BaseEntry::getRetData)
                .subscribe(
                        result -> updateData(currentCount, result),
                        throwable -> {
                            mPullToLoadView.setComplete();
                            showMessage(throwable.getMessage());
                        },
                        () -> mPullToLoadView.setComplete());
    }

    private void showMessage(CharSequence message) {
        if (getView() == null) {
            return;
        }
        Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
    }

    private void updateData(int start, List<City> data) {
        if (mListAdapter == null) {
            return;
        }
        List<City> target = mListAdapter.getData();
        if (target == null) {
            target = new ArrayList<>();
        }
        if (target.size() < start) {
            return;
        }
        if (start > 0) {
            List<City> save = target.subList(0, start);
            target.clear();
            target.addAll(save);
        } else if (target.size() > 0) {
            target.clear();
        }
        target.addAll(start, data);

        mListAdapter.setData(target);
        mListAdapter.notifyDataSetChanged();
    }

    private static class ListAdapter extends RecyclerView.Adapter<ViewHolder> {

        private List<City> mData;

        public void setData(List<City> data) {
            mData = data;
        }

        public List<City> getData() {
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

        private void populateView(City app) {
            mTvAppName.setText(app.getNameCn());
        }
    }
}
