package com.example.jihoonsong.excuseme;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TableSelectActivity extends Activity {
    ImageView button12;
    ImageView popupTableSelect;
    ImageView buttonYes;
    ImageView buttonNo;
    ImageView shadow;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Lock rotation.
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_select);

        button12 = (ImageView)findViewById(R.id.button_12);
        popupTableSelect = (ImageView)findViewById(R.id.popup_table_select);
        buttonYes = (ImageView)findViewById(R.id.button_yes);
        buttonNo = (ImageView)findViewById(R.id.button_no);
        shadow = (ImageView)findViewById(R.id.shadow);

        button12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.button_12) {
                    shadow.setVisibility(View.VISIBLE);
                    popupTableSelect.setVisibility(View.VISIBLE);
                    buttonYes.setClickable(true);
                    buttonNo.setClickable(true);
                }
            }
        });

        buttonYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.button_yes) {
                    startActivity(new Intent(TableSelectActivity.this, MenuSelectActivity.class));

                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                    System.gc();
                }
            }
        });

        buttonNo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.button_no) {
                    shadow.setVisibility(View.INVISIBLE);
                    popupTableSelect.setVisibility(View.INVISIBLE);
                    buttonYes.setClickable(false);
                    buttonNo.setClickable(false);
                }
            }
        });
    }
}
