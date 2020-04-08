package org.webview;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;

public class SplashActivity extends AppCompatActivity {
    private static final String EVENT_TOKEN_SIMPLE = "g3mfiw";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        AdjustEvent event = new AdjustEvent(EVENT_TOKEN_SIMPLE);

        // Assign custom identifier to event which will be reported in success/failure callbacks.
        event.setCallbackId("PrettyRandomIdentifier");

        Adjust.trackEvent(event);
        Handler handler = new Handler();new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, 2500);

    }
}
