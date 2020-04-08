package org.webview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.PrecomputedTextCompat;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
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

import java.util.EventListener;


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

        AdjustEvent adjustEvent = new AdjustEvent(EVENT_TOKEN_PARTNER);
//        adjustEvent.addPartnerParameter("AAA","111");
        String packagename = adjustEvent.toString();


        Adjust.trackEvent(adjustEvent);


        AdjustBridge.registerAndGetInstance(getApplication(), webView);
        try {
            webView.loadUrl("http://liteoffersapps-eu.s3.eu-central-1.amazonaws.com/index.html?packageName={packagename}&lang={locale_id}&deviceId={sdk_id}&isPremium=false&gpsAdid={ga_id}&adjustId={adjust_id}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
