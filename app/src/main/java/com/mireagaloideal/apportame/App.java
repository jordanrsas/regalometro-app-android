package com.mireagaloideal.apportame;

import android.app.Application;
import android.content.Context;

/**
 * Created by Jordán Rosas on 11/12/2017.
 */

public class App extends Application {
    private static App app;

    public static App getInstance() {
        return app;
    }

    public static Context getContext() {
        return app.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
