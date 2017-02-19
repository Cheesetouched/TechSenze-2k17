package com.rishabh.techsenze;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class AboutUs extends AppCompatActivity {

    private Toolbar toolbar;

    private Animation slide;

    private TabLayout tablayout;

    private ViewPager viewpager;

    private Button notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        notification = (Button) findViewById(R.id.notification);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        viewpager = (ViewPager) findViewById(R.id.viewpager);

        setUpViewPager(viewpager);

        tablayout = (TabLayout) findViewById(R.id.tablayout);

        tablayout.setupWithViewPager(viewpager);

        TabLayout.Tab tab = tablayout.getTabAt(0);

        tab.select();

        slide();

    }


    private void slide() {

        TranslateAnimation slide = new TranslateAnimation(0,0,500,0);

        slide.setDuration(1000);

        notification.setAnimation(slide);

    }


    public void setUpViewPager(ViewPager set) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new AboutEvent(), "Event");

        adapter.addFragment(new AboutCollege(), "College");

        set.setAdapter(adapter);

    }


}
