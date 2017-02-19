package com.rishabh.techsenze;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro;

public class Technical extends AppIntro {

    @Override
    public void init(Bundle savedInstanceState) {
        addSlide(SampleSlide.newInstance(R.layout.tech_one));
        addSlide(SampleSlide.newInstance(R.layout.tech_two));
        addSlide(SampleSlide.newInstance(R.layout.tech_three));
        addSlide(SampleSlide.newInstance(R.layout.tech_four));
        addSlide(SampleSlide.newInstance(R.layout.tech_five));
        addSlide(SampleSlide.newInstance(R.layout.tech_six));
        addSlide(SampleSlide.newInstance(R.layout.tech_seven));
        addSlide(SampleSlide.newInstance(R.layout.tech_eight));

        hideStatusBar();

        setFlowAnimation();

        setVibrate(true);

        setVibrateIntensity(100);

    }

    private void hideStatusBar() {

        Window window = getWindow();

        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    @Override
    public void onSkipPressed() {

        Intent skip = new Intent(this, MainActivity.class);

        startActivity(skip);

        finishAffinity();

    }

    @Override
    public void onNextPressed() {

    }

    @Override
    public void onDonePressed() {

        Intent done = new Intent(this, MainActivity.class);

        startActivity(done);

        finishAffinity();

    }

    @Override
    public void onSlideChanged() {

    }

    public void getStarted(View v) {

        Toast.makeText(getApplicationContext(), getString(R.string.skip), Toast.LENGTH_SHORT).show();

    }

}
