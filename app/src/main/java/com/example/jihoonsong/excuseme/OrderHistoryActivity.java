package com.example.jihoonsong.excuseme;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class OrderHistoryActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Lock rotation.
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
    }
}