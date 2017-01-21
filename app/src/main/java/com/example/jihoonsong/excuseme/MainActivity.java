package com.example.jihoonsong.excuseme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import org.androidannotations.annotations.EActivity;

@EActivity
public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Wait 1000 milliseconds and check start flags.
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            public void run() {
                SwapActivity();
            }
        }, 1000);
    }

    private void SwapActivity() {
        startActivity(new Intent(MainActivity.this, EnteringActivity.class));

        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
        System.gc();
    }
}
