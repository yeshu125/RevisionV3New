package com.android.alekhya.revisionv3.network.LoginModule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.alekhya.revisionv3.ActivityMain;
import com.android.alekhya.revisionv3.R;

/**
 * Created by Alekhya on 04-02-2018.
 */

public class SplashPage extends ActivityMain {
    Thread splash;
    Context ctx;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        ctx = this;
        splash = new Thread(){
            @Override
            public void run(){
                int x = 100;
                try{

                    while (x<4000)
                    {
                        sleep(200);
                        x = x+500;
                    }

                }
                catch(InterruptedException e){}
                finally {
                    Intent intent = new Intent(ctx,LoginActivityMain.class);
                    startActivity(intent);
                }
            }
        };
        splash.start();
    }
}