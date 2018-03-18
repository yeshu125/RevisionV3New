package com.android.alekhya.revisionv3.network.LoginModule;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.android.alekhya.revisionv3.ActivityMain;
import com.android.alekhya.revisionv3.BaseApplication;
import com.android.alekhya.revisionv3.network.SessionManager;

/**
 * Created by kkothagundu on 3/18/2018.
 */

public class SessionCheck extends Activity {
    private static View view;
    SessionManager session;

    public boolean checkActivity() {
        session = new SessionManager(getApplicationContext());
        session.createLoginSession(BaseApplication.username, BaseApplication.email);

        Intent intent = new Intent(view.getContext(), ActivityMain.class);
        startActivity(intent);
        finish();
        return true;
    }
}
