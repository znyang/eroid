package com.zen.android.center.sdk.injection.module;

import com.zen.android.center.sdk.AppCenterApi;
import com.zen.android.center.sdk.model.App;
import com.zen.android.center.sdk.model.UserSession;
import com.zen.android.center.sdk.store.user.UserLoginStore;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Observable;

/**
 * AppCenterModule
 *
 * @author zeny
 * @version 2015.12.06
 */
@Module
public class AppCenterModule {

    @Singleton
    @Provides
    AppCenterApi provideAppCenterApi() {
        return new AppCenterApi() {
            UserSession mLoginSession;

            @Override
            public boolean isLogin() {
                return mLoginSession != null && mLoginSession.getSessionToken() != null;
            }

            @Override
            public Observable<Boolean> login(String username, String password) {
                return new UserLoginStore(username, password)
                        .concat()
                        .doOnNext(session -> mLoginSession = session)
                        .map(session -> session.getSessionToken() != null);
            }

            @Override
            public Observable<Boolean> register(String username, String password) {
                return null;
            }

            @Override
            public Observable<List<App>> getAppList(int skip, int limit) {
                return null;
            }
        };
    }

}
