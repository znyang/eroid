package com.zen.android.center.sdk;

import com.zen.android.center.sdk.model.App;

import java.util.List;

import rx.Observable;

/**
 * AppCenterApi
 *
 * @author zeny
 * @version 2015.12.06
 */
public interface AppCenterApi {

    boolean isLogin();

    Observable<Boolean> login(String username, String password);

    Observable<Boolean> register(String username, String password);

    Observable<List<App>> getAppList(int skip, int limit);

}
