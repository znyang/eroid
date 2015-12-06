package com.zen.android.center.sdk.store.user;

import com.zen.android.center.sdk.model.UserSession;
import com.zen.android.center.sdk.protocol.entry.UserEntry;
import com.zen.android.center.sdk.store.BaseCenterStore;

import rx.Observable;

/**
 * UserRegisterStore
 *
 * @author zeny
 * @version 2015.12.06
 */
public class UserRegisterStore extends BaseCenterStore<UserSession> {

    private String mUsername;
    private String mPassword;

    public UserRegisterStore(String username, String password) {
        mUsername = username;
        mPassword = password;
    }

    @Override
    public Observable<UserSession> disk() {
        return Observable.empty();
    }

    @Override
    public Observable<UserSession> network() {
        return getClientApi().register(new UserEntry(mUsername, mPassword));
    }
}
