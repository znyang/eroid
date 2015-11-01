package com.zen.android.center.sdk.injection;

import com.zen.android.center.sdk.injection.component.CenterComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * TestCenterComponent
 *
 * @author zeny
 * @version 2015.10.29
 */
@Singleton
@Component(modules = {
        TestDataClientModule.class
})
public interface TestCenterComponent extends CenterComponent{

}
