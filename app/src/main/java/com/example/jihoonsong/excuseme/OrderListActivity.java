package com.example.jihoonsong.excuseme;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderListActivity extends Activity {
    ImageView orderConfirm;
    ImageView shadow;
    TextView orderConfirmMesg;
    ImageView orderConfirmMesgBg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Lock rotation.
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        orderConfirm = (ImageView)findViewById(R.id.button_order_confirm_active);
        shadow = (ImageView)findViewById(R.id.shadow);
        orderConfirmMesg = (TextView)findViewById(R.id.order_confirm_mesg);
        orderConfirmMesgBg = (ImageView)findViewById(R.id.order_confirm_mesg_bg);
        orderConfirmMesg.setTypeface(Typeface.createFromAsset(getAssets(), "HU들꽃140.ttf"));

        orderConfirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.button_order_confirm_active) {
                    shadow.setVisibility(View.VISIBLE);
                    orderConfirmMesg.setVisibility(View.VISIBLE);
                    orderConfirmMesgBg.setVisibility(View.VISIBLE);

                    Handler mHandler = new Handler();
                    mHandler.postDelayed(new Runnable() {
                        public void run() {
                            startActivity(new Intent(OrderListActivity.this, OrderHistoryActivity.class));

                            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                            finish();
                            System.gc();
                        }
                    }, 1100);
                }
            }
        });
    }
}