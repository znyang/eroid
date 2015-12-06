package com.zen.android.eroid.base;

import com.zen.android.eroid.BuildConfig;
import com.zen.android.eroid.IConfig;

import static junit.framework.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * ContextUtilTest
 *
 * @author zeny
 * @version 2015.12.05
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = IConfig.SDK_LEVEL,
        manifest = IConfig.MANIFEST_PATH)
public class ContextUtilTest {

    @Test
    public void testSet() throws Exception {
        ContextUtil.setAppContext(RuntimeEnvironment.application);
        assertEquals(RuntimeEnvironment.application, ContextUtil.getAppContext());
    }
}
