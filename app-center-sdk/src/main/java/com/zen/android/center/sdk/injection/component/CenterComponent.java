package com.zen.android.center.sdk.injection.component;

import com.zen.android.center.sdk.AppCenter;

public interface CenterComponent {

    void inject(AppCenter center);

    class Instance {
        private static CenterComponent sComponent;

        public static void init(CenterComponent component) {
            sComponent = component;
        }

        public static CenterComponent get() {
            return sComponent;
        }
    }

}
