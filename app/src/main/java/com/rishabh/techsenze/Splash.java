package com.rishabh.techsenze;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Intent go = new Intent(Splash.this, MainActivity.class);

        startActivity(go);

        finish();

    }

}