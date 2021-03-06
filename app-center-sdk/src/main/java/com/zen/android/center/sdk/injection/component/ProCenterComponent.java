package com.zen.android.center.sdk.injection.component;


import com.zen.android.center.sdk.injection.module.AppCenterModule;
import com.zen.android.center.sdk.injection.module.DataClientModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        DataClientModule.class,
        AppCenterModule.class
})
public interface ProCenterComponent extends CenterComponent {
}
