package com.zen.android.eroid.inject.component;

import com.zen.android.eroid.inject.module.DroidAppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * IProDroidComponent
 *
 * @author zeny
 * @version 2015.10.25
 */
@Singleton
@Component(modules = {
        DroidAppModule.class
})
public interface IProDroidComponent extends IDroidComponent {
}
