package com.zen.android.eroid.injection.component;

import com.zen.android.eroid.ui.DroidActivity;
import com.zen.android.eroid.ui.DroidFragment;

/**
 * IDroidComponent
 *
 * @author zeny
 * @version 2015.10.25
 */
public interface IDroidComponent {

    void inject(DroidActivity activity);

    void inject(DroidFragment fragment);

}
