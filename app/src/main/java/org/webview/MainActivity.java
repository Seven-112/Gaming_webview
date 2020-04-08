package org.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.adjust.sdk.webbridge.AdjustBridge;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    public String ga_id;
    public String package_name;
    public String adjust_id;
    public String device_id;
    public Locale locale_id;

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);

        SharedPreferences prefs = getSharedPreferences("info", MODE_PRIVATE);
        ga_id = prefs.getString("ga_id", "");
        adjust_id = prefs.getString("adjust_id", "");

        package_name = BuildConfig.APPLICATION_ID;
        locale_id = getResources().getConfiguration().locale;
        device_id = Settings.Secure.getString(MainActivity.this.getContentResolver(),Settings.Secure.ANDROID_ID);

//        webView.loadUrl("http://liteoffersapps-eu.s3.eu-central-1.amazonaws.com/m.html");
//        webView.loadUrl("http://liteoffersapps-eu.s3.eu-central-1.amazonaws.com/index.html?packageName={packagename}&lang={locale_id}&deviceId={sdk_id}&isPremium=false&gpsAdid={ga_id}&adjustId={adjust_id}");


        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());

        AdjustBridge.registerAndGetInstance(getApplication(), webView);
        try {
            webView.loadUrl("http://liteoffersapps-eu.s3.eu-central-1.amazonaws.com/index.html?packageName="+ package_name +"&lang="+ locale_id +"&deviceId="+ device_id +"&isPremium=false&gpsAdid=" + ga_id + "&adjustId=" + adjust_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
