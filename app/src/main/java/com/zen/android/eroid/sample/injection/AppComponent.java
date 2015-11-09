package com.zen.android.eroid.sample.injection;

import com.zen.android.eroid.sample.ui.base.BaseActivity;
import com.zen.android.eroid.sample.ui.base.BaseFragment;
import com.zen.android.eroid.sample.ui.base.BaseSingleFragmentActivity;

/**
 * AppComponent
 * <p>
 *
 * @author zeny
 * @version 2015/11/5
 */
public interface AppComponent {

    void inject(BaseActivity activity);

    void inject(BaseFragment fragment);

}
