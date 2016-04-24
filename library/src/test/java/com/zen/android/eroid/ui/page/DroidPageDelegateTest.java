package com.zen.android.eroid.ui.page;

import android.os.SystemClock;

import com.zen.android.eroid.BuildConfig;
import com.zen.android.eroid.IConfig;
import com.zen.android.eroid.ui.TestActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.concurrent.CountDownLatch;

import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;

/**
 * DroidPageDelegateTest
 *
 * @author zeny
 * @version 2015.12.06
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = IConfig.SDK_LEVEL,
        manifest = IConfig.MANIFEST_PATH)
public class DroidPageDelegateTest {

    DroidPageDelegate<TestActivity> mPageDelegate;

    @Before
    public void setUp() throws Exception {
        TestActivity activity = Robolectric.setupActivity(TestActivity.class);
        mPageDelegate = DroidPageDelegate.create(activity);
    }

    @Test
    public void testCollect() throws Exception {
        final CountDownLatch latch = new CountDownLatch(1);
        Observable<Integer> observable = Observable.defer(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("create value");
            return Observable.just(1);
        });
        Subscription subscription = observable
                .subscribeOn(Schedulers.newThread())
                .subscribe(data -> {
                    System.out.println("subscribe");
                    throw new RuntimeException("error");
                });
//        subscription.unsubscribe();
        System.out.println("unsubscribe");
        latch.countDown();
        Thread.sleep(50);
        System.out.println("end");
    }
}
