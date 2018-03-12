package com.android.alekhya.revisionv3;

import android.app.Application;

import com.android.alekhya.revisionv3.network.RestApi;

/**
 * Created by Alekhya on 15-02-2018.
 */

public class BaseApplication extends Application {

    public static String subjectId;
  //  public static String ipAddress="http://192.168.100.3:8080/Revision/";
    public static String ipAddress="http://192.168.3.73:8080/Revision/";
    public static String url;
    public static String filename;
    @Override
    public void onCreate() {
        super.onCreate();

        //Initialise rest api
        RestApi.init(this);
    }
}
