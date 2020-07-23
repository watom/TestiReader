package com.watom.ireader.main;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

public class IApplication extends Application {
    public static Context context;
    private static IApplication application;

    public static IApplication getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        application = this;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
