package com.forthorn.thorn.app;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by: Forthorn
 * Date: 4/2/2018.
 * Description:
 */

public class ThornApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        Utils.init(this);
    }
}
