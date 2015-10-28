package com.zen.android.center.sdk;

import com.zen.android.center.sdk.protocol.entry.UserEntry;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * AppCenterTest
 *
 * @author zeny
 * @version 2015.10.28
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = IConfig.SDK_LEVEL, manifest = IConfig.MANIFEST_PATH)
public class AppCenterTest extends TestCase{

    @Before
    public void setUp() throws Exception {
        AppCenter.init();
    }

    @Test
    public void testLogin() throws Exception {
        AppCenter.client().login("1", "22").subscribe();
    }

    @Test
    public void testRegister() throws Exception {
        UserEntry entry = new UserEntry("xggcl", "111111");
        AppCenter.client().register(entry).subscribe();
    }
}
