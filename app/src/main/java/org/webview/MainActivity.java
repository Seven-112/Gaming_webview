package org.webview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.PrecomputedTextCompat;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcel;
import android.provider.Settings;
import android.text.PrecomputedText;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.webbridge.AdjustBridge;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

import java.io.IOException;
import java.util.EventListener;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private static final String EVENT_TOKEN_SIMPLE = "g3mfiw";
    private static final String EVENT_TOKEN_REVENUE = "a4fd35";
    private static final String EVENT_TOKEN_CALLBACK = "34vgg9";
    private static final String EVENT_TOKEN_PARTNER = "w788qs";
    private WebView webView;
    Boolean exit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();

//        webView.loadUrl("http://liteoffersapps-eu.s3.eu-central-1.amazonaws.com/m.html");
//        webView.loadUrl("http://liteoffersapps-eu.s3.eu-central-1.amazonaws.com/index.html?packageName={packagename}&lang={locale_id}&deviceId={sdk_id}&isPremium=false&gpsAdid={ga_id}&adjustId={adjust_id}");

        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());

        Locale locale = getResources().getConfiguration().locale;
        String packageName = BuildConfig.APPLICATION_ID;

        AdjustEvent adjustEvent = new AdjustEvent(EVENT_TOKEN_PARTNER);
//        adjustEvent.addPartnerParameter("AAA","111");
        String packagename = adjustEvent.toString();


        Adjust.trackEvent(adjustEvent);


        AdjustBridge.registerAndGetInstance(getApplication(), webView);
        try {
            webView.loadUrl("http://liteoffersapps-eu.s3.eu-central-1.amazonaws.com/index.html?packageName="+ packageName +"&lang="+ locale +"&deviceId={sdk_id}&isPremium=false&gpsAdid=24b2fc90-4359-4831-8921-8aa0c651422a&adjustId={adjust_id}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
