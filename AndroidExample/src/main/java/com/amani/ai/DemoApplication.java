package com.amani.ai;

import android.app.Application;

import com.amani_ai.Amani;

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Amani.init(this);
    }
}
