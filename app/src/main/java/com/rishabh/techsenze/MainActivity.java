package com.rishabh.techsenze;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private Animation slide;

    private TabLayout tablayout;

    private ViewPager viewpager;

    private Button notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = (Button) findViewById(R.id.notification);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        viewpager = (ViewPager) findViewById(R.id.viewpager);

        setUpViewPager(viewpager);

        tablayout = (TabLayout) findViewById(R.id.tablayout);

        tablayout.setupWithViewPager(viewpager);

        TabLayout.Tab tab = tablayout.getTabAt(1);

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

        adapter.addFragment(new Events(), "Events");

        adapter.addFragment(new News(), "News");

        adapter.addFragment(new Sponsors(), "Sponsors");

        set.setAdapter(adapter);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.ourteam:

                Intent go = new Intent(MainActivity.this, OurTeam.class);

                startActivity(go);

                return true;

            case R.id.aboutus:

                Intent start = new Intent(MainActivity.this, AboutUs.class);

                startActivity(start);

                return true;

            case R.id.aboutdeveloper:

                Intent dev = new Intent(MainActivity.this, Developer.class);

                startActivity(dev);

                return true;

            default:

                return super.onOptionsItemSelected(item);

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


}
