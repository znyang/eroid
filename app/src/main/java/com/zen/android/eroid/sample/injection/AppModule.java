package com.zen.android.eroid.sample.injection;

import com.zen.android.center.sdk.AppCenter;
import com.zen.android.center.sdk.protocol.ClientApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * AppModule
 * <p>
 *
 * @author zeny
 * @version 2015/11/5
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    public ClientApi provideClientApi(AppCenter center) {
        return center.getApi();
    }

    @Provides
    @Singleton
    public AppCenter provideAppCenter() {
        return new AppCenter();
    }
}
