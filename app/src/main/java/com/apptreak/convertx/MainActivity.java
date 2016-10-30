package com.apptreak.convertx;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity  {
    Toolbar toolbar;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.length);
        //Pushing drawable
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tab_icon_length));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tab_icon_area));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tab_icon_temperature2));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tab_icon_weight1));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tab_icon_time1));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tab_volume1));
        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#1a237e"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.parseColor("#1a237e"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(3).getIcon().setColorFilter(Color.parseColor("#1a237e"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(4).getIcon().setColorFilter(Color.parseColor("#1a237e"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(5).getIcon().setColorFilter(Color.parseColor("#1a237e"), PorterDuff.Mode.SRC_IN);


        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                switch(tab.getPosition()) {
                    case 0:
                        viewPager.setCurrentItem(0);
                        toolbar.setTitle(R.string.length);
                        tab.getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
                        break;
                    case 1:
                        viewPager.setCurrentItem(1);
                        toolbar.setTitle(R.string.area);
                        tab.getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
                        break;
                    case 2:
                        viewPager.setCurrentItem(2);
                        toolbar.setTitle(R.string.temp);
                        tab.getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
                        break;
                    case 3:
                        viewPager.setCurrentItem(3);
                        toolbar.setTitle(R.string.weight);
                        tab.getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
                        break;
                    case 4:
                        viewPager.setCurrentItem(4);
                        toolbar.setTitle(R.string.time);
                        tab.getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
                        break;
                    case 5:
                        viewPager.setCurrentItem(5);
                        toolbar.setTitle(R.string.vol);
                        tab.getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
                        break;




            }}

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#1a237e"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
            }
        });
    }


}
