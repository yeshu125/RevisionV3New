package com.android.alekhya.revisionv3;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsServiceConnection;
import android.text.TextUtils;
import android.util.Log;

import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;

import java.util.List;

public class Units extends Activity implements OnPageChangeListener,OnLoadCompleteListener {
    private static final String EXTRA_CUSTOM_TABS_TOOLBAR_COLOR = "android.support.customtabs.extra.TOOLBAR_COLOR";
    private static final String PACKAGE_NAME = "com.android.chrome";
    Integer pageNumber = 0;
    private CustomTabsClient mClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaypdf);
        warmUpChrome();
        launchUrl();
    }
    private void warmUpChrome() {
        CustomTabsServiceConnection service = new CustomTabsServiceConnection() {
            @Override
            public void onCustomTabsServiceConnected(ComponentName name, CustomTabsClient client) {
                mClient = client;
                mClient.warmup(0);
            }
            @Override
            public void onServiceDisconnected(ComponentName name) {
                mClient = null;
            }
        };
        CustomTabsClient.bindCustomTabsService(getApplicationContext(),PACKAGE_NAME, service);
    }
    private void launchUrl() {
        Uri uri = Uri.parse(BaseApplication.ipAddress + BaseApplication.url + "/" + BaseApplication.filename);
        Log.e("URI",uri.toString());
        if (uri == null) {
            return;
        }
        CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder().build();
        customTabsIntent.intent.setData(uri);
        customTabsIntent.intent.putExtra(EXTRA_CUSTOM_TABS_TOOLBAR_COLOR, getResources().getColor(R.color.colorPrimaryDark));
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> resolveInfoList = packageManager.queryIntentActivities(customTabsIntent.intent, PackageManager.MATCH_DEFAULT_ONLY);
        for (ResolveInfo resolveInfo : resolveInfoList) {
            String packageName = resolveInfo.activityInfo.packageName;
            if (TextUtils.equals(packageName, PACKAGE_NAME))
                customTabsIntent.intent.setPackage(PACKAGE_NAME);
        }
        customTabsIntent.launchUrl(this, uri);
    }
    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
    }
    @Override
    public void loadComplete(int nbPages) {
    }
}
