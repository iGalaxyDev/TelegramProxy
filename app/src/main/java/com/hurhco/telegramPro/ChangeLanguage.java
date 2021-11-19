package com.hurhco.telegramPro;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.akexorcist.localizationactivity.core.LocalizationApplicationDelegate;

public class ChangeLanguage extends Application {
    LocalizationApplicationDelegate localizationDelegate = new LocalizationApplicationDelegate();

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(localizationDelegate.attachBaseContext(base));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        localizationDelegate.onConfigurationChanged(this);
    }

    @Override
    public Context getApplicationContext() {
        return localizationDelegate.getApplicationContext(super.getApplicationContext());
    }
}

