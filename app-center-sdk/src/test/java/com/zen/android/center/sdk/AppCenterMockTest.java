package com.zen.android.center.sdk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertTrue;

/**
 * AppCenterMockTest
 *
 * @author zeny
 * @version 2015.10.29
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = IConfig.SDK_LEVEL,
        manifest = IConfig.MANIFEST_PATH, application = TestApplication.class)
public class AppCenterMockTest {

    @Test
    public void testLogin() throws Exception {
        boolean result = new AppCenter().getApi().login("123", "234").toBlocking().last();
        assertTrue(result);
    }


    @Test
    public void testRegister() throws Exception {
        boolean result = new AppCenter().getApi().register("123", "234").toBlocking().last();
        assertTrue(result);
    }
}
