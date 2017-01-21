package com.example.jihoonsong.excuseme;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class PayingActivity extends Activity {
    ImageView pay;
    ImageView inputMesg;
    EditText payingInput;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Lock rotation.
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paying);

        pay = (ImageView)findViewById(R.id.button_pay);
        inputMesg = (ImageView)findViewById(R.id.mesg_paying_input);
        payingInput = (EditText)findViewById(R.id.edit_paying_input);

        pay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.button_pay) {
                    Handler mHandler = new Handler();
                    mHandler.postDelayed(new Runnable() {
                        public void run() {
                            startActivity(new Intent(PayingActivity.this, MobileIspActivity.class));

                            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                            finish();
                            System.gc();
                        }
                    }, 800);
                }
            }
        });

        payingInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                inputMesg.setVisibility(View.INVISIBLE);
            }
        });
    }
}