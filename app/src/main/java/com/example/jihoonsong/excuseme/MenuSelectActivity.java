package com.example.jihoonsong.excuseme;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MenuSelectActivity extends Activity {
    ImageView orderInactive;
    ImageView orderOne;
    ImageView orderTwo;
    ImageView menuFirst;
    ImageView menuSecond;
    ImageView menuThird;
    ImageView shadowMenuFirst;
    ImageView shadowMenuSecond;
    ImageView shadowMenuThird;

    Animation fadeIn;
    Animation fadeOut;

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
        shadowMenuFirst = (ImageView)findViewById(R.id.button_shadow_menu_first);
        shadowMenuSecond = (ImageView)findViewById(R.id.button_shadow_menu_second);
        shadowMenuThird = (ImageView)findViewById(R.id.button_shadow_menu_third);

        fadeIn = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        fadeOut = AnimationUtils.loadAnimation(this,R.anim.fade_out);

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

                    shadowMenuFirst.setVisibility(View.VISIBLE);
                    shadowMenuFirst.setAnimation(fadeIn);
                    Handler mHandler = new Handler();
                    mHandler.postDelayed(new Runnable() {
                        public void run() {
                            shadowMenuFirst.setAnimation(fadeOut);
                            shadowMenuFirst.setVisibility(View.INVISIBLE);
                        }
                    }, 200);
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

                    shadowMenuSecond.setVisibility(View.VISIBLE);
                    shadowMenuSecond.setAnimation(fadeIn);
                    Handler mHandler = new Handler();
                    mHandler.postDelayed(new Runnable() {
                        public void run() {
                            shadowMenuSecond.setAnimation(fadeOut);
                            shadowMenuSecond.setVisibility(View.INVISIBLE);
                        }
                    }, 200);
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

                    shadowMenuThird.setVisibility(View.VISIBLE);
                    shadowMenuThird.setAnimation(fadeIn);
                    Handler mHandler = new Handler();
                    mHandler.postDelayed(new Runnable() {
                        public void run() {
                            shadowMenuThird.setAnimation(fadeOut);
                            shadowMenuThird.setVisibility(View.INVISIBLE);
                        }
                    }, 200);
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