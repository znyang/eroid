package com.zen.android.center.sdk.injection;

import com.zen.android.center.sdk.model.App;
import com.zen.android.center.sdk.model.LoginSession;
import com.zen.android.center.sdk.model.RowEntry;
import com.zen.android.center.sdk.model.UserSession;
import com.zen.android.center.sdk.protocol.ClientApi;
import com.zen.android.center.sdk.protocol.entry.UserEntry;

import java.util.List;

import static org.mockito.Mockito.*;

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
                UserSession session = mock(UserSession.class);
                when(session.getSessionToken()).thenReturn("register-token");
                return Observable.just(session);
            }

            @Override
            public Observable<LoginSession> login(@Query(FIELD_USERNAME) String username,
                                                  @Query(FIELD_PASSWORD) String password) {
                LoginSession session = mock(LoginSession.class);
                when(session.getSessionToken()).thenReturn("login-token");
                return Observable.just(session);
            }

            @Override
            @SuppressWarnings("unchecked")
            public Observable<RowEntry<App>> getAppList(@Query(FIELD_SKIP) int skip,
                                                        @Query(FIELD_LIMIT) int limit) {
                App app = mock(App.class);
                when(app.getAppName()).thenReturn("hehe");

                List list = mock(List.class);
                list.add(app);

                RowEntry entry = mock(RowEntry.class);
                when(entry.getResults()).thenReturn(list);
                return Observable.just(entry);
            }
        };
    }

}
