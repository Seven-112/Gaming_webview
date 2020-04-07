package org.webview;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.AdjustEvent;

public class FunPlusAdjust implements Application.ActivityLifecycleCallbacks {

    public FunPlusAdjust(Application application, String appToken, String environment, String appOpenEventToken) {
        AdjustConfig adjustConfig = new AdjustConfig(application, appToken, environment);
        Adjust.onCreate(adjustConfig);
        application.registerActivityLifecycleCallbacks(this);

        trackEvent(appOpenEventToken);
    }

    public void trackEvent(String eventToken) {
        String uid = "todo";
        AdjustEvent event = new AdjustEvent(eventToken);
        event.addCallbackParameter("fpid", uid);
        Adjust.trackEvent(event);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        Adjust.onResume();
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Adjust.onPause();
    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
