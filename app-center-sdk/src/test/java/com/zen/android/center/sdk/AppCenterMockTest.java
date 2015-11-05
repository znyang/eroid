package com.zen.android.center.sdk;

import com.zen.android.center.sdk.base.EvilReference;
import com.zen.android.center.sdk.model.LoginSession;
import com.zen.android.center.sdk.model.UserSession;
import com.zen.android.center.sdk.protocol.entry.UserEntry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

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
        EvilReference<LoginSession> session = new EvilReference<>(null);
        new AppCenter().getApi().login("123", "234").subscribe(session::setData);
        assertEquals(session.getData().getSessionToken(), "login-token");
    }


    @Test
    public void testRegister() throws Exception {
        EvilReference<UserSession> session = new EvilReference<>(null);
        new AppCenter().getApi().register(new UserEntry("123","234")).subscribe(session::setData);
        assertEquals(session.getData().getSessionToken(), "register-token");

    }
}
