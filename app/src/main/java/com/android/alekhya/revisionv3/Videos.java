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
import com.shockwave.pdfium.PdfDocument;

import java.util.List;

public class Videos extends Activity implements OnPageChangeListener,OnLoadCompleteListener {
        public static final String SAMPLE_FILE = "v.mp4";
    private static final String TAG = Videos.class.getSimpleName();
    private static final String EXTRA_CUSTOM_TABS_TOOLBAR_COLOR = "android.support.customtabs.extra.TOOLBAR_COLOR";
    private static final String PACKAGE_NAME = "com.android.chrome";
        //  PDFView pdfView;
        Integer pageNumber = 0;
        String pdfFileName;
        private CustomTabsClient mClient;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.displaypdf);
            displayFromAsset(SAMPLE_FILE);
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
            // customTabsIntent.intent;
            customTabsIntent.intent.putExtra(EXTRA_CUSTOM_TABS_TOOLBAR_COLOR, getResources().getColor(R.color.colorPrimaryDark));
            // customTabsIntent.intent.putExtra(EXTRA_CUSTOM_TABS_TOOLBAR_COLOR, getResources().getColor(R.color.colorPrimaryDark));


            PackageManager packageManager = getPackageManager();
            List<ResolveInfo> resolveInfoList = packageManager.queryIntentActivities(customTabsIntent.intent, PackageManager.MATCH_DEFAULT_ONLY);

            for (ResolveInfo resolveInfo : resolveInfoList) {
                String packageName = resolveInfo.activityInfo.packageName;
                if (TextUtils.equals(packageName, PACKAGE_NAME))
                    customTabsIntent.intent.setPackage(PACKAGE_NAME);
            }

            customTabsIntent.launchUrl(this, uri);
        }
        private void displayFromAsset(String assetFileName) {
            pdfFileName = assetFileName;

      /*  pdfView.fromAsset(SAMPLE_FILE)
                .defaultPage(pageNumber)
                .enableSwipe(true)

                .swipeHorizontal(false)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .load(); */
      /*  pdfView.fromUri(Uri.parse("http://192.168.2.3:80/demo/Revision/PdfUploadFolder/"+pdfFileName))
                .defaultPage(pageNumber)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
  */  }


        @Override
        public void onPageChanged(int page, int pageCount) {
            pageNumber = page;
            setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pageCount));
        }


        @Override
        public void loadComplete(int nbPages) {
            //   PdfDocument.Meta meta = pdfView.getDocumentMeta();
            //  printBookmarksTree(pdfView.getTableOfContents(), "-");

        }

        public void printBookmarksTree(List<PdfDocument.Bookmark> tree, String sep) {
            for (PdfDocument.Bookmark b : tree) {

                Log.e(TAG, String.format("%s %s, p %d", sep, b.getTitle(), b.getPageIdx()));

                if (b.hasChildren()) {
                    printBookmarksTree(b.getChildren(), sep + "-");
                }
            }
        }

    }
