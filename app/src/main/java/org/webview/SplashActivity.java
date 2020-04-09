package org.webview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;

import java.util.Locale;

import static android.Manifest.permission.READ_PHONE_STATE;

public class SplashActivity extends AppCompatActivity {

    public String ga_id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences prefs = getSharedPreferences("info", MODE_PRIVATE);
        ga_id = prefs.getString("ga_id", "");

        Handler handler = new Handler();new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                intent.putExtra("ga_id", ga_id);
                startActivity(intent);
            }
        }, 2500);

    }

}
