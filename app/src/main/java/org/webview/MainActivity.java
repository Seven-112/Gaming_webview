package org.webview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.OnDeviceIdsRead;
import com.adjust.sdk.webbridge.AdjustBridge;

import java.util.Locale;
import java.util.UUID;

import static android.Manifest.permission.READ_PHONE_STATE;


public class MainActivity extends AppCompatActivity {

    public String ga_id = "";
    public String package_name;
    public String adjust_id;
    public String device_id;
    public String locale_id;

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);

        SharedPreferences prefs = getSharedPreferences("info", MODE_PRIVATE);
        ga_id = prefs.getString("ga_id", "");

        package_name = BuildConfig.APPLICATION_ID;

        device_id = Settings.Secure.getString(MainActivity.this.getContentResolver(),Settings.Secure.ANDROID_ID);

        adjust_id = Adjust.getAdid();

        String[] language = Locale.getDefault().toString().split("_");
        locale_id = language[0];

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
