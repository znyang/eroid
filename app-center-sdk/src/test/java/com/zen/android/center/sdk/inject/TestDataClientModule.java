package com.zen.android.center.sdk.inject;

import com.zen.android.center.sdk.model.LoginSession;
import com.zen.android.center.sdk.model.UserSession;
import com.zen.android.center.sdk.protocol.ClientApi;
import com.zen.android.center.sdk.protocol.entry.UserEntry;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.http.Body;
import retrofit.http.Query;
import rx.Observable;

/**
 * TestDataClientModule
 *
 * @author zeny
 * @version 2015.10.29
 */
@Module
public class TestDataClientModule {

    @Singleton
    @Provides
    public ClientApi provideClientApi() {
        return new ClientApi() {

            @Override
            public Observable<UserSession> register(@Body UserEntry userEntry) {
                return Observable.just(new UserSession());
            }

            @Override
            public Observable<LoginSession> login(@Query(FIELD_USERNAME) String username,
                                                  @Query(FIELD_PASSWORD) String password) {
                return Observable.just(new LoginSession());
            }
        };
    }

}
