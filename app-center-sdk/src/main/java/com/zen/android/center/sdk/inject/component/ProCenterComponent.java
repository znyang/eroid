package com.zen.android.center.sdk.inject.component;


import com.zen.android.center.sdk.inject.module.DataClientModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        DataClientModule.class
})
public interface ProCenterComponent extends CenterComponent {
}
