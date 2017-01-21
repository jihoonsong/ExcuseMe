package com.example.jihoonsong.excuseme;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;

public class MainActivity extends AppCompatActivity {
    @AfterViews
    protected void init() {
        // Lock rotation.
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
