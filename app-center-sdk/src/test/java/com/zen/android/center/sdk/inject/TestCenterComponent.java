package com.zen.android.center.sdk.inject;

import com.zen.android.center.sdk.inject.component.CenterComponent;

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
