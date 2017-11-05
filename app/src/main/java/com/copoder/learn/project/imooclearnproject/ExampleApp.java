package com.copoder.learn.project.imooclearnproject;

import android.app.Application;

import com.copoder.learn.project.core_library.app.COCA;

/**
 * Created by copoder on 2017/11/5.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        COCA.init(this).configFinish();
    }
}
