package org.webview;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;

import static android.Manifest.permission.READ_PHONE_STATE;

public class SplashActivity extends AppCompatActivity {
    private static final String EVENT_TOKEN_SIMPLE = "g3mfiw";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (CheckingPermissionIsEnabledOrNot()){
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
        else {
            RequestMultiplePermission();
        }



    }


    public boolean CheckingPermissionIsEnabledOrNot() {

        int FirstPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), READ_PHONE_STATE);

        return FirstPermissionResult == PackageManager.PERMISSION_GRANTED;
    }

    private void RequestMultiplePermission() {

        // Creating String Array with Permissions.
        ActivityCompat.requestPermissions(SplashActivity.this, new String[]
                {
                        READ_PHONE_STATE
                }, 999);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {

            case 999:

                if (grantResults.length > 0) {

                    boolean ReadStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED;

                    if (ReadStorage) {
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
                    else {
                        Toast.makeText(SplashActivity.this,"Permission Denied", Toast.LENGTH_LONG).show();

                    }
                }

                break;
        }
    }

}
