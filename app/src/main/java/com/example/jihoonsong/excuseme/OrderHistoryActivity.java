package com.example.jihoonsong.excuseme;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class OrderHistoryActivity extends Activity {
    ImageView payActive;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Lock rotation.
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        payActive = (ImageView)findViewById(R.id.button_pay_active);

        payActive.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.button_pay_active) {
                    startActivity(new Intent(OrderHistoryActivity.this, PayingActivity.class));

                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                    System.gc();
                }
            }
        });
    }
}