package com.zen.android.center.sdk.store.user;

import com.zen.android.center.sdk.model.LoginSession;
import com.zen.android.center.sdk.store.BaseCenterStore;

import rx.Observable;

/**
 * UserLoginStore
 *
 * @author zeny
 * @version 2015.12.06
 */
public class UserLoginStore extends BaseCenterStore<LoginSession> {

    private String mUsername;
    private String mPassword;

    public UserLoginStore(String username, String password) {
        mUsername = username;
        mPassword = password;
    }

    @Override
    public Observable<LoginSession> disk() {
        return Observable.empty();
    }

    @Override
    public Observable<LoginSession> network() {
        return getClientApi().login(mUsername, mPassword);
    }
}
