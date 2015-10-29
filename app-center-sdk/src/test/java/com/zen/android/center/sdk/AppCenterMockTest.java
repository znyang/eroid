package com.zen.android.center.sdk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * AppCenterMockTest
 *
 * @author zeny
 * @version 2015.10.29
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = IConfig.SDK_LEVEL, manifest = IConfig.MANIFEST_PATH, application = TestApplication.class)
public class AppCenterMockTest {

    @Test
    public void testLogin() throws Exception {
        AppCenter.client().login("123","234").subscribe();
    }
}
