package com.zen.android.eroid.sample.injection;

import javax.inject.Singleton;

import dagger.Component;

/**
 * IProAppComponent
 * <p>
 *
 * @author zeny
 * @version 2015/11/5
 */
@Singleton
@Component(
        modules = {AppModule.class}
)
public interface IProAppComponent extends AppComponent{
}
