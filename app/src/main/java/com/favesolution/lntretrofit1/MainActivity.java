package com.favesolution.lntretrofit1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TabLayout tl_main;
    ViewPager vp_main;
    MyPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tl_main = findViewById(R.id.tl_main);
        vp_main = findViewById(R.id.vp_main);
        setupViewPager(vp_main);
        tl_main.setupWithViewPager(vp_main);
    }

    public void setupViewPager(ViewPager viewPager){
        if (myPagerAdapter== null){
            myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
            myPagerAdapter.addFragment(new FirstFragment(), "First");
            myPagerAdapter.addFragment(new SecondFragment(), "Second");
            viewPager.setAdapter(myPagerAdapter);
        }
    }
}
