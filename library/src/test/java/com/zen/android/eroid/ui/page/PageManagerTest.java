package com.zen.android.eroid.ui.page;

import android.app.Activity;
import android.graphics.pdf.PdfDocument;

import static junit.framework.Assert.*;

import com.zen.android.eroid.BuildConfig;
import com.zen.android.eroid.IConfig;
import com.zen.android.eroid.ui.TestAActivity;
import com.zen.android.eroid.ui.TestActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * PageManagerTest
 *
 * @author zeny
 * @version 2015.12.06
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = IConfig.SDK_LEVEL,
        manifest = IConfig.MANIFEST_PATH)
public class PageManagerTest {

    TestActivity  mActivity  = null;
    TestAActivity mActivityA = null;

    @Before
    public void setUp() throws Exception {
        mActivity = Robolectric.setupActivity(TestActivity.class);
        mActivityA = Robolectric.setupActivity(TestAActivity.class);
        PageManager.getInstance().add(mActivity);
        PageManager.getInstance().add(mActivityA);
    }

    @Test
    public void testClear() throws Exception {
        PageManager.getInstance().clear();
        assertTrue(mActivity.isFinishing());
        assertTrue(mActivityA.isFinishing());
    }

    @Test
    public void testClearExcept() throws Exception {
        PageManager.getInstance().clearExcept(TestActivity.class);
        assertTrue(mActivityA.isFinishing());
        assertFalse(mActivity.isFinishing());
    }
}
