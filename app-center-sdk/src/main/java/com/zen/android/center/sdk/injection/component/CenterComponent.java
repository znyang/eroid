package com.zen.android.center.sdk.injection.component;

import com.zen.android.center.sdk.AppCenter;
import com.zen.android.center.sdk.store.CenterStoreHelper;

public interface CenterComponent {

    void inject(AppCenter center);

    void inject(CenterStoreHelper helper);

    class Instance {
        private static CenterComponent sComponent;

        public static void init(CenterComponent component) {
            sComponent = component;
        }

        public static CenterComponent get() {
            if (sComponent == null) {
                sComponent = DaggerProCenterComponent.builder().build();
            }
            return sComponent;
        }
    }

}
