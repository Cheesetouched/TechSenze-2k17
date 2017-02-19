package com.rishabh.techsenze;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout statuspanel;

    private Typeface logo;

    private TextView header;

    private TextView status;

    private Animation slide;

    private String name;

    private String mobile;

    private String pin;

    private EditText nameinput;

    private EditText mobileinput;

    private EditText pininput;

    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        logo = Typeface.createFromAsset(getAssets(), "fonts/default.otf");

        header = (TextView) findViewById(R.id.header);

        nameinput = (EditText) findViewById(R.id.name);

        mobileinput = (EditText) findViewById(R.id.mobile);

        pininput = (EditText) findViewById(R.id.pin);

        register = (Button) findViewById(R.id.register);

        register.setOnClickListener(this);

        status = (TextView) findViewById(R.id.status);

        statuspanel = (LinearLayout) findViewById(R.id.statuspanel);

        statuspanel.setVisibility(View.GONE);

        header.setTypeface(logo);

        slideUp(header);

    }


    private void slideUp(View view) {

        slide = new TranslateAnimation(0, 0, 500, 0);

        slide.setDuration(1000);

        view.setAnimation(slide);

    }


    private void slideDown(View view) {

        slide = new TranslateAnimation(0, 0, 0, 500);

        slide.setDuration(1000);

        view.setAnimation(slide);

    }


    private void statusBarDelay() {

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                slideDown(statuspanel);

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        statuspanel.setVisibility(View.GONE);

                        register.setEnabled(true);

                    }
                }, 100);

            }
        }, 2000);

    }


    private void emptyCheck() {

        register.setEnabled(false);

        name = nameinput.getText().toString().trim();

        mobile = mobileinput.getText().toString().trim();

        pin = pininput.getText().toString();

        if (name.isEmpty()) {

            statuspanel.setVisibility(View.VISIBLE);

            slideUp(statuspanel);

            status.setBackgroundColor(Color.parseColor("#FF7043"));

            status.setText("Enter Your Full Name");

            statusBarDelay();

            return;

        } else {

            if (mobile.isEmpty()) {

                statuspanel.setVisibility(View.VISIBLE);

                slideUp(statuspanel);

                status.setBackgroundColor(Color.parseColor("#FF7043"));

                status.setText("Enter Your Mobile Number");

                statusBarDelay();

                return;

            } else {

                if (mobile.length() != 10) {

                    statuspanel.setVisibility(View.VISIBLE);

                    slideUp(statuspanel);

                    status.setBackgroundColor(Color.parseColor("#FF7043"));

                    status.setText("Incorrect Mobile Number");

                    statusBarDelay();

                    return;

                } else {

                    if (pin.isEmpty()) {

                        statuspanel.setVisibility(View.VISIBLE);

                        slideUp(statuspanel);

                        status.setBackgroundColor(Color.parseColor("#FF7043"));

                        status.setText("Enter Your Email");

                        statusBarDelay();

                        return;

                    } else {

                        if (!pin.contains("@")) {

                            statuspanel.setVisibility(View.VISIBLE);

                            slideUp(statuspanel);

                            status.setBackgroundColor(Color.parseColor("#FF7043"));

                            status.setText("Incorrect Email");

                            statusBarDelay();

                            return;

                        } else {

                            statuspanel.setVisibility(View.VISIBLE);

                            slideUp(statuspanel);

                            status.setBackgroundColor(Color.parseColor("#FF7043"));

                            status.setText("Registering You! Please Wait");

                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    status.setBackgroundColor(Color.parseColor("#66BB6A"));

                                    status.setText("Successfully Registered!");

                                    final Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {

                                            Intent go = new Intent(Register.this, MainActivity.class);

                                            startActivity(go);

                                            finishAffinity();

                                        }
                                    }, 2000);

                                }
                            }, 3000);

                        }

                    }

                }

            }

        }

    }


    @Override
    public void onClick(View view) {

        if (view == register) {

            emptyCheck();

        }

    }


}