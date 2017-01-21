package com.example.jihoonsong.excuseme;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class OrderListActivity extends Activity {
    ImageView orderConfirm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Lock rotation.
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        orderConfirm = (ImageView)findViewById(R.id.button_order_confirm_active);

        orderConfirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.button_order_confirm_active) {
                    startActivity(new Intent(OrderListActivity.this, OrderHistoryActivity.class));

                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                    System.gc();
                }
            }
        });
    }
}