package com.example.jihoonsong.excuseme;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MenuSelectActivity extends Activity {
    ImageView orderInactive;
    ImageView orderOne;
    ImageView orderTwo;
    ImageView menuFirst;
    ImageView menuSecond;
    ImageView menuThird;

    int orderCount = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Lock rotation.
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_select);

        orderInactive = (ImageView)findViewById(R.id.button_order_inactive);
        orderOne = (ImageView)findViewById(R.id.button_order_one);
        orderTwo = (ImageView)findViewById(R.id.button_order_two);
        menuFirst = (ImageView)findViewById(R.id.button_menu_first);
        menuSecond = (ImageView)findViewById(R.id.button_menu_second);
        menuThird = (ImageView)findViewById(R.id.button_menu_third);

        orderTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.button_order_two) {
                    startActivity(new Intent(MenuSelectActivity.this, OrderListActivity.class));

                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                    System.gc();
                }
            }
        });

        menuFirst.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.button_menu_first) {
                    ++orderCount;
                    if(orderCount > 2)
                    {
                        orderCount = 2;
                    }

                    updateOrderButton();
                }
            }
        });

        menuSecond.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.button_menu_second) {
                    ++orderCount;
                    if(orderCount > 2)
                    {
                        orderCount = 2;
                    }

                    updateOrderButton();
                }
            }
        });

        menuThird.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.button_menu_third) {
                    ++orderCount;
                    if(orderCount > 2)
                    {
                        orderCount = 2;
                    }

                    updateOrderButton();
                }
            }
        });
    }

    private void updateOrderButton() {
        switch(orderCount)
        {
            case 1:
                orderInactive.setVisibility(View.INVISIBLE);
                orderOne.setVisibility(View.VISIBLE);
                orderTwo.setVisibility(View.INVISIBLE);
                break;
            case 2:
                orderInactive.setVisibility(View.INVISIBLE);
                orderOne.setVisibility(View.INVISIBLE);
                orderTwo.setVisibility(View.VISIBLE);
                break;
            default:
                Log.d("(updateOrderButton())", "Order counting error");
                break;
        }
    }
}