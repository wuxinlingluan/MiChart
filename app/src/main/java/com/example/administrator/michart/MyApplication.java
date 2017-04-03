package com.example.administrator.michart;

import android.app.Application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.controller.EaseUI;

/**
 * Created by ${sheldon} on 2017/4/3.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        EaseUI.getInstance().init(this, null);
        EMClient.getInstance().setDebugMode(true);
    }
}
