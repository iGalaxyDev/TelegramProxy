package com.proxyfortelegram.powerful.proxy.fastproxy.helpers;

import android.util.Log;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.proxyfortelegram.powerful.proxy.fastproxy.R;

public class RemoteConfig {
    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    private String TAG = "TestRemoteConfig";

    private RemoteConfig() {
    }

    public static RemoteConfig getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private static class SingletonHelper {
        private static final RemoteConfig INSTANCE = new RemoteConfig();
    }

    public void init() {
        remoteConfig();
        CheckRemoteConfig();
    }

    private void remoteConfig() {
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(3600)
                .build();
        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);
        mFirebaseRemoteConfig.setDefaultsAsync(R.xml.remote_config_defaults);
        mFirebaseRemoteConfig.fetchAndActivate();
    }

    //region Ad Rules

    public boolean buttonMobAdsRules() {
        return mFirebaseRemoteConfig.getBoolean("CAN_SHOW_BUTTON_MOB_AD");
    }

    public boolean listAdsRules() {
        return mFirebaseRemoteConfig.getBoolean("CAN_SHOW_LIST_MOB_AD");
    }

    public boolean appodealAdRules() {
        return mFirebaseRemoteConfig.getBoolean("CAN_SHOW_DEAL_AD");
    }

    public boolean appOpenAdsRules() {
        return mFirebaseRemoteConfig.getBoolean("CAN_SHOW_APP_OPEN_AD");
    }

    //endregion

    // region Ad Unit Parameters

    public String appOpenUnitId() {
        return (String) mFirebaseRemoteConfig.getString("APP_OPEN_UNIT_ID");
    }

    public String bannerUnitId() {
        return (String) mFirebaseRemoteConfig.getString("BANNER_UNIT_ID");
    }

    public String listInterstitialUnitId() {
        return (String) mFirebaseRemoteConfig.getString("LIST_INTERSTITIAL_UNIT_ID");
    }

    public String buttonInterstitialUnitId() {
        return (String) mFirebaseRemoteConfig.getString("BUTTON_INTERSTITIAL_UNIT_ID");
    }

    public String appodealAppId() {
        return (String) mFirebaseRemoteConfig.getString("APPODEAL_APP_ID");
    }

    //endregion

    public void CheckRemoteConfig() {
        Log.i(TAG, "CAN_SHOW_BUTTON_MOB_AD" +": " + mFirebaseRemoteConfig.getBoolean("CAN_SHOW_BUTTON_MOB_AD"));
        Log.i(TAG, "CAN_SHOW_LIST_MOB_AD" +": " + mFirebaseRemoteConfig.getBoolean("CAN_SHOW_LIST_MOB_AD"));
        Log.i(TAG, "CAN_SHOW_DEAL_AD" +": " + mFirebaseRemoteConfig.getBoolean("CAN_SHOW_DEAL_AD"));
        Log.i(TAG, "CAN_SHOW_APP_OPEN_AD" +": " + mFirebaseRemoteConfig.getBoolean("CAN_SHOW_APP_OPEN_ADCAN_SHOW_APP_OPEN_AD"));

        Log.i(TAG, "APP_OPEN_UNIT_ID" +": " + mFirebaseRemoteConfig.getString("APP_OPEN_UNIT_ID"));
        Log.i(TAG, "BANNER_UNIT_ID" +": " + mFirebaseRemoteConfig.getString("BANNER_UNIT_ID"));
        Log.i(TAG, "LIST_INTERSTITIAL_UNIT_ID" +": " + mFirebaseRemoteConfig.getString("LIST_INTERSTITIAL_UNIT_ID"));
        Log.i(TAG, "BUTTON_INTERSTITIAL_UNIT_ID" +": " + mFirebaseRemoteConfig.getString("BUTTON_INTERSTITIAL_UNIT_ID"));
        Log.i(TAG, "APPODEAL_APP_ID" +": " + mFirebaseRemoteConfig.getString("APPODEAL_APP_ID"));
    }
}
