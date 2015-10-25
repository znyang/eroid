package com.zen.android.eroid.inject.component;

import com.zen.android.eroid.ui.DroidActivity;
import com.zen.android.eroid.ui.DroidFragment;

/**
 * IDroidAppComponent
 *
 * @author zeny
 * @version 2015.10.25
 */
public interface IDroidAppComponent {

    void inject(DroidActivity activity);

    void inject(DroidFragment fragment);

}
