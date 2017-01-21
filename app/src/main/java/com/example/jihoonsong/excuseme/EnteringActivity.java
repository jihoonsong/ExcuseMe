package com.example.jihoonsong.excuseme;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class EnteringActivity extends Activity {
    ImageView popupEntering;
    ImageView buttonOk;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Lock rotation.
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entering);

        popupEntering = (ImageView)findViewById(R.id.popup_entering);
        buttonOk = (ImageView)findViewById(R.id.button_ok);

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            public void run() {
                popupEntering.setVisibility(View.VISIBLE);
            }
        }, 1000);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.button_ok) {
                    startActivity(new Intent(EnteringActivity.this, TableSelectActivity.class));

                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                    System.gc();
                }
            }
        });
    }
}