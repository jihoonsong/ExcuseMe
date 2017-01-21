package com.example.jihoonsong.excuseme;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Lock rotation.
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            public void run() {
                SwapActivity();
            }
        }, 1300);
    }

    private void SwapActivity() {
        startActivity(new Intent(MainActivity.this, EnteringActivity.class));

        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
        System.gc();
    }
}
